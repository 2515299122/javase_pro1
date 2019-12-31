package utils;

import controller.AdminFunction;
import domain.Admin;
import domain.Logging;
import domain.Staff;
import service.AdminService;
import service.StaffService;
import service.impl.StaffServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class ServiceInvocationHandler {
    private static Long start,end;
    public static Object getProxyInstance(Class T, final String user){

        if(T.getName().contains("AdminService")){
            final AdminService service = (AdminService) FactoryUtils.getObject(T);
            final Object proxy= Proxy.newProxyInstance(T.getClassLoader(), T.getInterfaces(), new InvocationHandler() {
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    Object obj=null;
                    Logging logging = FactoryUtils.getObject(Logging.class);
                    logging.setMethod(method.getName());
                    logging.setUser(user);
                    //获取执行方法时的时间
                    logging.setDate(DateUtils.changePattern(new Date()));
                    start=System.nanoTime();
                    obj=method.invoke(service,args);
                    end=System.nanoTime();
                    logging.setMethodTime(end-start);
                    service.insertLogging(logging);
                    return obj;
                }
            });
            return proxy;
        }
        if(T.getName().contains("StaffService")){
            final StaffService service = (StaffService) FactoryUtils.getObject(T);
            Object proxy= Proxy.newProxyInstance(T.getClassLoader(), T.getInterfaces(), new InvocationHandler() {
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                    Logging logging = FactoryUtils.getObject(Logging.class);
                    logging.setMethod(method.getName());
                    logging.setUser(user);
                    //获取执行方法时的时间
                    logging.setDate(DateUtils.changePattern(new Date()));
                    start=System.nanoTime();
                    Object obj=method.invoke(service,args);
                    end=System.nanoTime();
                    logging.setMethodTime(end-start);
                    service.insertLogging(logging);
                    return obj;
                }
            });
            return proxy;
        }
        System.out.println("没有值哦");
        return null;
    }

}

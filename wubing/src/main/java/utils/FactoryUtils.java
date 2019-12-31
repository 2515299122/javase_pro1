package utils;

public class FactoryUtils {
    private static final FactoryUtils factory=new FactoryUtils();//保证整个程序中的工厂单一
    //构造方法私有化
    private FactoryUtils(){}
    public static FactoryUtils getFactory(){
        return factory;
    }
    public static <T>T getObject(Class<T> T) {
        return factory.getInstance(T);
    }
    public  <T>T getInstance(Class<T> T){//通过反射创建对象
        try {
            return T.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}

package controller;

import com.mysql.jdbc.StatementImpl;
import domain.Staff;
import service.StaffService;
import service.impl.StaffServiceImpl;
import utils.FactoryUtils;
import utils.ServiceInvocationHandler;

import java.util.Scanner;

public class StaffFunction {
    Scanner scanner=new Scanner(System.in);
    public void findOne(Staff staff){
        StaffService staffService= (StaffService) ServiceInvocationHandler.getProxyInstance(StaffServiceImpl.class,staff.getUsername());
        staffService.findOne(staff.getId());//这一行没有任何作用，仅用于记录日志
        System.out.println(staff);

    }
    public void update(Staff staff){
        StaffService staffService= (StaffService) ServiceInvocationHandler.getProxyInstance(StaffServiceImpl.class,staff.getUsername());
        System.out.println("当前密码为"+staff.getPassword());
        System.out.println("请输入新密码");
        staff.setPassword(scanner.next());
        staffService.update(staff);
        System.out.println("修改成功");
    }
}

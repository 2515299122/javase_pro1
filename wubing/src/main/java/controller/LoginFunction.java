package controller;

import domain.Admin;
import domain.Staff;
import service.AdminService;
import service.StaffService;
import service.impl.AdminServiceImpl;
import service.impl.StaffServiceImpl;
import utils.CheckCodeUtils;
import utils.FactoryUtils;
import utils.SleepUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
//登录功能的展示
public class LoginFunction {
    public void AdminLogin(){
        AdminMeun adminMeun=FactoryUtils.getObject(AdminMeun.class);
        Scanner scanner= new Scanner(System.in);
        AdminService adminService =FactoryUtils.getObject(AdminServiceImpl.class);
        List<Integer> list;//生成随机验证码
        String username,password;
        boolean flag=true;//便于循环，验证码及账号密码正确置为false跳出循环
        int result;

        do {
            list= CheckCodeUtils.getCheckCode();//前两个数为生成的随机数，第三个数为其之和
            System.out.println(list.get(0) + "+" + list.get(1) + "=");
            System.out.print("请输入账号");
            username=scanner.next();
            System.out.print("请输入密码");
            password=scanner.next();
            System.out.println("请输入最上方等式的答案");
            result = scanner.nextInt();
            if (result != list.get(2)) {//先判断验证码，错误重新输入
                System.out.println("验证码错误");
                flag=false;
                continue;
            }
            if(adminService.findOne(username,password)==null){
                System.out.println("账号或密码错误，请重新输入");
                flag=false;
                continue;
            }
            flag=true;
        }while(!flag);
        System.out.println("进入系统成功");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        adminMeun.show();
    }

    public void StaffLogin(){
        Scanner scanner= new Scanner(System.in);
        StaffMeun staffMeun = FactoryUtils.getObject(StaffMeun.class);
        StaffService staffService =FactoryUtils.getObject(StaffServiceImpl.class);
        List<Integer> list;//生成随机验证码
        String username,password;
        boolean flag=true;//便于循环，验证码及账号密码正确置为false跳出循环
        int result;
        Staff staff=null;

        do {
            list= CheckCodeUtils.getCheckCode();//前两个数为生成的随机数，第三个数为其之和
            System.out.println(list.get(0) + "+" + list.get(1) + "=");
            System.out.print("请输入账号");
            username=scanner.next();
            System.out.print("请输入密码");
            password=scanner.next();
            System.out.println("请输入最上方等式的答案");
            result = scanner.nextInt();
            if (result != list.get(2)) {//先判断验证码，错误重新输入
                System.out.println("验证码错误");
                flag=false;
                continue;
            }
            staff=staffService.findOne(username,password);
            if(staff==null){
                System.out.println("账号或密码错误，请重新输入");
                flag=false;
                continue;
            }
            flag=true;
        }while(!flag);
        System.out.println("进入系统成功");
        SleepUtils.sleep();
        staffMeun.show(staff);
    }
}

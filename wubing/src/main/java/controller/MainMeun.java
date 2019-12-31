package controller;

import dao.LoggingDao;
import dao.impl.LoggingDaoImpl;
import utils.FactoryUtils;

import java.util.Scanner;

public class MainMeun {
    Scanner scanner=new Scanner(System.in);
    LoginFunction loginFunction=FactoryUtils.getObject(LoginFunction.class);
    LogginShow logginShow=FactoryUtils.getObject(LogginShow.class);
    public void show(){
        int choice;
        boolean flag=true;
        do {
            System.out.println("1.管理登录");
            System.out.println("2.员工登录");
            System.out.println("3.显示日志");
            System.out.println("4.退出登录");
            System.out.print("请进行你的操作：");
            choice=scanner.nextInt();
            switch (choice){
                case 1:loginFunction.AdminLogin();
                    break;
                case 2:loginFunction.StaffLogin();
                    break;
                case 3:logginShow.show(0,5);
                   break;
                case 4:flag=false;
                    break;
                default:
                    System.out.println("输入错误，请重新输入");
                    break;
            }
        }while(flag);
    }
    public static void main(String[] args) {
        MainMeun main = FactoryUtils.getObject(MainMeun.class);
        main.show();
    }
}

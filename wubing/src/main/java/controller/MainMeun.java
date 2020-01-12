package controller;

import utils.FactoryUtils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainMeun {
    private Scanner scanner=new Scanner(System.in);
    private LoginFunction loginFunction=FactoryUtils.getObject(LoginFunction.class);
    private LogginShow logginShow=FactoryUtils.getObject(LogginShow.class);
    private void show() throws Exception {
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
                case 1:loginFunction.adminLogin();
                    break;
                case 2:loginFunction.staffLogin();
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
        try{
            main.show();
        }catch (InputMismatchException e){
            System.out.println("输入异常，程序终止");
        }catch (Exception e){
            System.out.println("程序运行时出错！！！");
        }

    }
}

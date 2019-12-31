package controller;

import service.AdminService;
import service.impl.AdminServiceImpl;
import utils.FactoryUtils;

import java.util.Scanner;

public class AdminMeun {
    Scanner scanner=new Scanner(System.in);
    AdminFunction adminFunction=FactoryUtils.getObject(AdminFunction.class);
    public void show(){
        int choice;
        boolean flag=true;
        do {
            System.out.println("1.查看员工信息");
            System.out.println("2.查看部门信息");
            System.out.println("3.修改员工信息");
            System.out.println("4.修改账号密码");
            System.out.println("5.添加员工");
            System.out.println("6.添加部门");
            System.out.println("7.删除员工");
            System.out.println("8.返回上一级");
            System.out.print("请进行你的操作：");
            choice=scanner.nextInt();
            switch (choice){
                case 1:adminFunction.findAllStaff();
                    break;
                case 2:adminFunction.findAllDepartment();
                    break;
                case 3:adminFunction.updateStaff();
                    break;
                case 4:adminFunction.update();
                    break;
                case 5:adminFunction.insertStaff();
                    break;
                case 6: adminFunction.insertDepartment();
                    break;
                case 7:adminFunction.deleteStaff();
                    break;
                case 8: flag=false;
                    break;
                default:
                    System.out.println("输入错误，请重新输入");
                    break;
            }
        }while(flag);

    }
}

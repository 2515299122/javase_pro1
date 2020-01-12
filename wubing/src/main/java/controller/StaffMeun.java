package controller;

import domain.Staff;
import utils.FactoryUtils;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Administrator
 */
public class StaffMeun {
    private Scanner scanner=new Scanner(System.in);
    private StaffFunction staffFunction= FactoryUtils.getObject(StaffFunction.class);
    void show(Staff staff) throws Exception {
        int choice;
        boolean flag=true;
        do {
            System.out.println("1.查看本人信息");
            System.out.println("2.修改密码");
            System.out.println("3.返回上一级");
            System.out.print("请进行你的操作：");
            choice=scanner.nextInt();
            switch (choice){
                case 1:staffFunction.findOne(staff);
                    break;
                case 2:staffFunction.update(staff);
                    break;
                case 3:flag=false;
                    break;
                default:
                    System.out.println("输入错误，请重新输入");
                    break;
            }
        }while(flag);
    }


}

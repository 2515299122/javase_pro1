package controller;

import dao.LoggingDao;
import dao.impl.LoggingDaoImpl;
import domain.Logging;
import utils.FactoryUtils;

import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class LogginShow {
    LoggingDao loggingDao= FactoryUtils.getObject(LoggingDaoImpl.class);
    Scanner scanner=new Scanner(System.in);

    void show(Integer page, Integer size)throws Exception{
        int choice;
        List<Logging> list = loggingDao.findByPage(page,size);
        if(list!=null&&list.size()!=0){
            for (Logging logging : list) {
                System.out.println(logging);
            }
            System.out.println("按1进入下一页");
            try{
                choice=scanner.nextInt();
            }catch (InputMismatchException e){
                System.out.println("输入错误，请重新输入");
                choice=scanner.nextInt();
            }

            //递归查询
            if(choice==1){
                page=(page+1)*size;
                show(page, size);
            }
        }else {
            System.out.println("列表为空");
            System.out.println("输入任意数退出");
            scanner.next();
        }

    }
}

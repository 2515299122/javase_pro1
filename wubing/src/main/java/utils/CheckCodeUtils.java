package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CheckCodeUtils {
    public static List<Integer> getCheckCode(){
        int code;
        List<Integer> list=new ArrayList<Integer>();
        Random random=new Random();
        for (int i = 0; i < 2; i++) {
            code= (int) (Math.random()*100);
            list.add(i,code);
        }
        list.add(2,list.get(0)+list.get(1));
       return list;
    }

    public static void main(String[] args) {
        CheckCodeUtils u = FactoryUtils.getObject(CheckCodeUtils.class);
        System.out.println(u.getCheckCode());
    }
}

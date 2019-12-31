package testutils;

import domain.Admin;
import org.junit.Test;
import utils.FactoryUtils;

public class FactoryUtilsTest {
    FactoryUtils factory= FactoryUtils.getFactory();
    @Test
    public void getFactory(){
        for(int i=0;i<10;i++) {
            System.out.println(FactoryUtils.getFactory());
        }
    }
    @Test
    public void getObject(){
        Admin admin=factory.getObject(Admin.class);
        admin.setPassword("123");
        System.out.println(admin);
    }
}

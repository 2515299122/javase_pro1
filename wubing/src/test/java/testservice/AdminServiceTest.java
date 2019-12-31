package testservice;

import domain.Admin;
import domain.Staff;
import org.junit.Test;
import service.AdminService;
import service.impl.AdminServiceImpl;
import utils.FactoryUtils;
import utils.ServiceInvocationHandler;

import java.util.List;

public class AdminServiceTest {
    private AdminService adminService= (AdminService) ServiceInvocationHandler.getProxyInstance(AdminServiceImpl.class,"admin");
    @Test
    public void findOne(){
        Admin admin = adminService.findOne("root","root");
        System.out.println(admin);
    }
    @Test
    public void findAllStaff(){
        List<Staff> l = adminService.findAllStaff();
        for (Staff staff : l) {
            System.out.println(staff);
        }
    }
}

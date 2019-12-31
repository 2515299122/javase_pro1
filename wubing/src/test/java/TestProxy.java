import org.junit.Test;
import service.AdminService;
import service.StaffService;
import service.impl.AdminServiceImpl;
import service.impl.StaffServiceImpl;
import utils.ServiceInvocationHandler;

public class TestProxy {
    @Test
    public void test(){
        StaffService staff = (StaffService) ServiceInvocationHandler.getProxyInstance(StaffServiceImpl.class,"qq");
        staff.test();
    }
}

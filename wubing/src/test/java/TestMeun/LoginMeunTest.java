package TestMeun;

import controller.LoginFunction;
import utils.FactoryUtils;

public class LoginMeunTest {
    public static void main(String[] args) {
        LoginFunction meun= FactoryUtils.getObject(LoginFunction.class);
        //测试管理员登录
        //meun.AdminLogin();
        meun.StaffLogin();
    }
}

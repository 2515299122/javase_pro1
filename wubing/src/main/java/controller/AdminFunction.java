package controller;

import domain.Admin;
import domain.Department;
import domain.Staff;
import service.AdminService;
import service.impl.AdminServiceImpl;
import utils.FactoryUtils;
import utils.ServiceInvocationHandler;
import utils.SleepUtils;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

//管理员的具体操作功能
public class AdminFunction {
    Scanner scanner=new Scanner(System.in);
    AdminService adminService=(AdminService) ServiceInvocationHandler.getProxyInstance(AdminServiceImpl.class,"admin");
    void findAllStaff()throws Exception{
        List<Staff> list = adminService.findAllStaff();
        for (Staff staff : list) {
            System.out.println(staff);
        }
    }
    void findAllDepartment()throws Exception{
        List<Department> list = adminService.findAllDepartment();
        for (Department department1 : list) {
            System.out.println(department1);
        }
    }

    //更新管理员的账号密码
    void update()throws InputMismatchException,Exception{//修改管理员账号密码
        Admin admin=FactoryUtils.getObject(Admin.class);
        System.out.println("当前账号为："+adminService.findOne().getUsername());
        System.out.println("当前密码为："+adminService.findOne().getPassword());
        System.out.println("请输入新账号");
        admin.setUsername(scanner.next());
        System.out.println("请输入新密码");
        admin.setPassword(scanner.next());
        adminService.update(admin);
        System.out.println("修改成功");
        SleepUtils.sleep();
    }
    void updateStaff()throws InputMismatchException,Exception{
        boolean flag=true;
        findAllStaff();
        System.out.println("请输入编号：");
        int id=scanner.nextInt();
        Staff staff = adminService.findStaffById(id);
        System.out.println(staff);
        System.out.println("请输入薪水");
        staff.setSalary(scanner.nextDouble());
        isDepartment(flag, staff);
        adminService.updateStaff(staff);
    }

    void insertDepartment()throws InputMismatchException,Exception{
        findAllDepartment();
        Department department = FactoryUtils.getObject(Department.class);
        System.out.println("请输入部门名称");
        department.setName(scanner.next());
        adminService.InsertDepartment(department);
    }
    void insertStaff()throws InputMismatchException,Exception{
        boolean flag=true;
        Staff s = FactoryUtils.getObject(Staff.class);
        System.out.println("请输入用户名");
        s.setUsername(scanner.next());
        System.out.println("请输入密码");
        s.setPassword(scanner.next());
        System.out.println("请输入姓名");
        s.setName(scanner.next());
        System.out.println("请输入工资");
        s.setSalary(scanner.nextDouble());
        s=isDepartment(flag, s);
        adminService.insertStaff(s);
    }

    void deleteStaff()throws InputMismatchException,Exception{
        System.out.println("请输入要删除的员工用户名：（支持模糊查询）");
        String username=scanner.next();
        List<Staff> list = adminService.findByUsername(username);
        for (Staff staff : list) {
            System.out.println(staff);
        }
        System.out.println("请输入要删除员工的id");
        adminService.deleteStaff(scanner.nextInt());
        System.out.println("删除成功");
    }
    //判断录入的部门是否存在
    private Staff isDepartment(boolean flag, Staff s) throws InputMismatchException,Exception {
        do {
            System.out.println("请输入部门");
            String department = scanner.next();
            List<Department> list = adminService.findAllDepartment();
            for (Department department1 : list) {
                if(department.equals(department1.getName())){
                    s.setDid(department1.getId());
                    flag=false;
                    break;
                }
            }
            if(flag){
                System.out.println("此部门不存在，请重新输入");
            }
        }while(flag);
        return s;
    }
}

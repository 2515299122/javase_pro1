package service.impl;

import dao.AdminDao;
import dao.DepartmentDao;
import dao.LoggingDao;
import dao.StaffDao;
import dao.impl.AdminDaoImpl;
import dao.impl.DepartmentDaoImpl;
import dao.impl.LoggingDaoImpl;
import dao.impl.StaffDaoImpl;
import domain.Admin;
import domain.Department;
import domain.Logging;
import domain.Staff;
import service.AdminService;
import utils.FactoryUtils;

import java.util.List;

public class AdminServiceImpl implements AdminService {
    private AdminDao adminDao=FactoryUtils.getObject(AdminDaoImpl.class);
    private StaffDao staffDao=FactoryUtils.getObject(StaffDaoImpl.class);
    private DepartmentDao departmentDao=FactoryUtils.getObject(DepartmentDaoImpl.class);
    private LoggingDao loggingDao=FactoryUtils.getObject(LoggingDaoImpl.class);

    //通过账号密码查询，用于检验登录
    public Admin findOne(String username,String password) {
        return adminDao.findOne(username,password);
    }
    public Admin findOne() {
        return adminDao.findOne();
    }
    public List<Staff> findAllStaff() {
        return staffDao.findAll();
    }
    public Staff findStaffById(Integer id) {
        return staffDao.findById(id);
    }
    public List<Staff> findByUsername(String username) {
        List<Staff> list = staffDao.findByUsername(username);
        for (Staff staff : list) {
            staff.setDepartment(departmentDao.findById(staff.getDid()));
        }
        return list;
    }
    public List<Department> findAllDepartment() {
        return departmentDao.findAll();
    }

    public void update(Admin admin) {
        adminDao.update(admin);
    }
    public void updateStaff(Staff staff) {
        staffDao.update(staff);
    }

    public void deleteStaff(Integer id) {
        staffDao.delete(id);
    }

    public void InsertDepartment(Department department) {
        departmentDao.insert(department);
    }
    public void insertLogging(Logging logging) {
        loggingDao.insert(logging);
    }
    public void insertStaff(Staff staff) {
        staffDao.insert(staff);
    }



}

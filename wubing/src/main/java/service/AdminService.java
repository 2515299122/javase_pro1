package service;

import domain.Admin;
import domain.Department;
import domain.Logging;
import domain.Staff;

import java.util.List;

public interface AdminService {
    Admin findOne(String username,String password);
    Admin findOne();
    void update(Admin admin);

    List<Staff> findAllStaff();
    Staff findStaffById(Integer id);
    List<Staff> findByUsername(String username);
    void updateStaff(Staff staff);
    void insertStaff(Staff staff);
    void deleteStaff(Integer id);

    void InsertDepartment(Department department);
    List<Department> findAllDepartment();

    void insertLogging(Logging logging);
}

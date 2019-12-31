package dao;

import domain.Department;

import java.util.List;

public interface DepartmentDao {
    List<Department> findAll();
    Department findById(Integer id);

    void insert(Department department);

}

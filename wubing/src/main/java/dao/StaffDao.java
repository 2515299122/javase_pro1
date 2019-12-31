package dao;

import domain.Staff;

import java.util.List;

public interface StaffDao {
    List<Staff> findAll();
    Staff findById(Integer id);
    List<Staff> findByUsername(String username);
    Staff findOne(String username,String password);

    void update(Staff staff);

    void insert(Staff staff);

    void delete(Integer id);
}

package dao;

import domain.Admin;
import domain.Staff;

public interface AdminDao {

    public Admin findOne(String username,String password);
    public Admin findOne();

    void update(Admin admin);

}

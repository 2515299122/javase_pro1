package service;

import domain.Logging;
import domain.Staff;

public interface StaffService {
    Staff findOne(String usename,String password);
    Staff findOne(Integer id);

    void update(Staff staff);

    void insertLogging(Logging logging);

    void test();
}

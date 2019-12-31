package service.impl;

import dao.DepartmentDao;
import dao.LoggingDao;
import dao.StaffDao;
import dao.impl.DepartmentDaoImpl;
import dao.impl.LoggingDaoImpl;
import dao.impl.StaffDaoImpl;
import domain.Logging;
import domain.Staff;
import service.StaffService;
import utils.FactoryUtils;

public class StaffServiceImpl implements StaffService {
    private LoggingDao loggingDao=FactoryUtils.getObject(LoggingDaoImpl.class);
    private StaffDao staffDao= FactoryUtils.getObject(StaffDaoImpl.class);
    private DepartmentDao departmentDao=FactoryUtils.getObject(DepartmentDaoImpl.class);

    public Staff findOne(String usename, String password) {
        Staff staff=staffDao.findOne(usename, password);
        if(staff!=null){
            staff.setDepartment(departmentDao.findById(staff.getDid()));
        }
        return staff;
    }

    public Staff findOne(Integer id) {
        return staffDao.findById(id);
    }

    public void update(Staff staff) {
        staffDao.update(staff);
    }

    public void insertLogging(Logging logging) {
        loggingDao.insert(logging);
    }

    public void test() {
        System.out.println("仅用于测试");
    }
}

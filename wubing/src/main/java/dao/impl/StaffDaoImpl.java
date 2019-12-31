package dao.impl;

import dao.DepartmentDao;
import dao.StaffDao;
import domain.Staff;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.FactoryUtils;
import utils.JDBCUtils;

import java.util.List;

public class StaffDaoImpl implements StaffDao {
    JdbcTemplate jdbcTemplate=new JdbcTemplate(JDBCUtils.getDataSource());
    DepartmentDao departmentDao= FactoryUtils.getObject(DepartmentDaoImpl.class);
    public List<Staff> findAll() {
        String sql="select * from staff";
        List<Staff> list=jdbcTemplate.query(sql,new BeanPropertyRowMapper<Staff>(Staff.class));
        for (Staff staff : list) {
            staff.setDepartment(departmentDao.findById(staff.getDid()));
        }
        return list;
    }
    public Staff findById(Integer id) {
        String sql="select * from staff where id=?";
        Staff staff = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Staff>(Staff.class),id);
        staff.setDepartment(departmentDao.findById(staff.getDid()));
        return staff;
    }
    //通过用户名查询员工，支持模糊查询
    public List<Staff> findByUsername(String username) {
        String sql="select * from staff where username like ?";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<Staff>(Staff.class),"%"+username+"%");
    }
    public Staff findOne(String username, String password) {
        String sql="select * from staff where username=? and password=?";
        try {
           return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Staff>(Staff.class),username,password);
        } catch (DataAccessException e) {
            return null;
        }
    }

    public void update(Staff staff) {
        String sql="update staff set username=?,password=?,name=?,salary=?,Did=? where id=?";
        jdbcTemplate.update(sql,staff.getUsername(),staff.getPassword(),staff.getSalary(),
                staff.getSalary(),staff.getDid(),staff.getId());
    }

    public void insert(Staff staff) {
        String sql="insert into staff values(null,?,?,?,?,?)";
        jdbcTemplate.update(sql,staff.getUsername(),
                staff.getPassword(),staff.getName(),staff.getSalary(),staff.getDid());
    }

    public void delete(Integer id) {
        String sql="delete from staff where id=?";
        jdbcTemplate.update(sql,id);
    }
}

package dao.impl;

import dao.AdminDao;
import domain.Admin;
import domain.Staff;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

import java.util.List;
import java.util.Scanner;

public class AdminDaoImpl implements AdminDao {
    JdbcTemplate jdbcTemplate=new JdbcTemplate(JDBCUtils.getDataSource());

    public Admin findOne(String username,String password) {
        String sql="select * from admin where username=? and password=?";
        Admin admin = null;
        try {
            admin = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Admin>(Admin.class),username,password);
        } catch (DataAccessException e) {
            return null;
        }
        return admin;
    }
    public Admin findOne() {
        String sql="select * from admin";
        Admin admin = jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<Admin>(Admin.class));
        return admin;
    }

    public void update(Admin admin) {
        String sql="update admin set username=?,password=?";
        jdbcTemplate.update(sql,admin.getUsername(),admin.getPassword());
    }


}

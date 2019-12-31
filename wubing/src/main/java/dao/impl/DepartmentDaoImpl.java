package dao.impl;

import dao.DepartmentDao;
import domain.Department;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

import java.util.List;

public class DepartmentDaoImpl implements DepartmentDao {
    JdbcTemplate jdbcTemplate=new JdbcTemplate(JDBCUtils.getDataSource());
    public List<Department> findAll() {
        String sql="select * from department";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Department>(Department.class));
    }
    public Department findById(Integer id) {
        String sql="select * from department where id=?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Department>(Department.class), id);
    }

    public void insert(Department department) {
        String sql="insert into department values(null,?)";
        jdbcTemplate.update(sql,department.getName());
    }


}

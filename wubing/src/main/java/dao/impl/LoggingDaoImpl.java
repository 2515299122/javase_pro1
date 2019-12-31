package dao.impl;

import com.alibaba.druid.util.JdbcUtils;
import dao.LoggingDao;
import domain.Logging;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

import java.util.List;

public class LoggingDaoImpl implements LoggingDao {
    JdbcTemplate jdbcTemplate=new JdbcTemplate(JDBCUtils.getDataSource());
    public void insert(Logging logging) {
        String sql="insert into logging values(null,?,?,?,?)";
        jdbcTemplate.update(sql,logging.getUser(),logging.getMethod(),logging.getDate(),logging.getMethodTime());
    }

    public List<Logging> findByPage(Integer page,Integer size) {
        String sql="select * from logging limit ?,?";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<Logging>(Logging.class),page,size);
    }
}

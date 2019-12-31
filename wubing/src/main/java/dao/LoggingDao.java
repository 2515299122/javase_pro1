package dao;

import domain.Logging;

import java.util.List;

public interface LoggingDao {
    public void insert(Logging logging);
    public List<Logging> findByPage(Integer page,Integer size);
}

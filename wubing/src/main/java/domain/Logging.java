package domain;

import java.util.Date;

public class Logging {
    private Integer id;
    private  String User;
    private String method;
    private String date;
    private Long methodTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String user) {
        User = user;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Long getMethodTime() {
        return methodTime;
    }

    public void setMethodTime(Long methodTime) {
        this.methodTime = methodTime;
    }

    @Override
    public String toString() {
        return "Logging{" +
                "id=" + id +
                ", User='" + User + '\'' +
                ", method='" + method + '\'' +
                ", date=" + date +
                ", methodTime=" + methodTime +"纳秒"+
                '}';
    }
}

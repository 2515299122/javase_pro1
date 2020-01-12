package domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class Logging implements Serializable {
    private Integer id;
    private  String User;
    private String method;
    private String date;
    private Long methodTime;
}

package domain;

import lombok.Data;

import java.io.Serializable;
@Data
public class Staff extends User implements Serializable {
    private String name;
    private Double salary;
    private Integer Did;
    private Department department;

}

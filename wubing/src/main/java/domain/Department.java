package domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Department implements Serializable {
    private Integer id;
    private String name;
}

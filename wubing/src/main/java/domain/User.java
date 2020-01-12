package domain;

import lombok.Data;

@Data
class User {
    private Integer id;
    private String username;
    private String password;
}

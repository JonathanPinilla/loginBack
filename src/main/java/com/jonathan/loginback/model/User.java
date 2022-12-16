package com.jonathan.loginback.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "user")
@Data
public class User {

    public User(String name, String lName, String uName, String email,String password, ROLE role) {
        this.name = name;
        this.lName = lName;
        this.uName = uName;
        this.email = email;
        this.password = password;
        this.role = role;
        this.creationDate = LocalDateTime.now();
        this.loginDate = LocalDateTime.now();
        this.active = true;
    }

    @Id
    private String id;
    private String name;
    private String lName;
    private String uName;
    private String email;
    private String password;
    private ROLE role;
    private LocalDateTime creationDate;
    private LocalDateTime loginDate;
    private boolean active;

    private enum ROLE {USER, ADMIN, OWNER};
}

package com.jonathan.loginback.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "user")
@Data
public class User {

    @Id
    private String id;
    private String name;
    private String lName;
    private String uName;
    private String email;
    private Date creationDate;
    private Date loginDate;
    private boolean active;
}

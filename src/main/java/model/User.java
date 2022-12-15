package model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "user")
public class User {

    @Id
    private String id;
    private String name;
    private String lName;
    private String uName;
    private String email;
    private Date creationDate;
    private Date loginDate;
}

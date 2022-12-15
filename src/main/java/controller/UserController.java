package controller;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.UserService;

@RequestMapping(path = "/api/v1/users")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "/get-all")
    public String getAllUsers(){
        return "Working";
    }
}

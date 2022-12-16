package com.jonathan.loginback.controller;

import com.jonathan.loginback.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jonathan.loginback.service.UserService;

@RequestMapping(path = "/api/v1/users")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "/get-all")
    public Iterable<User> getAllUsers(){
        return userService.findUsers();
    }
}

package com.jonathan.loginback.controller;

import com.jonathan.loginback.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.jonathan.loginback.service.UserService;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(path = "/create")
    public User createUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @GetMapping(path = "/get-all")
    public Iterable<User> getAllUsers(){
        return userService.findUsers();
    }

    @PutMapping(path = "/update/{id}")
    public User updateUser(@PathVariable("id") String id, @RequestBody User user){
        try{
            Optional<User> userToUpdate = userService.findUserById(id);
            userToUpdate.get().setActive(user.isActive());
            userToUpdate.get().setEmail(user.getEmail());
            userToUpdate.get().setName(user.getName());
            userToUpdate.get().setLName(user.getLName());
            userToUpdate.get().setUName(user.getName());
            userToUpdate.get().setLoginDate(user.getLoginDate());

            return userService.saveUser(userToUpdate.get());
        }catch (Exception error){
            throw new IllegalArgumentException(error);
        }
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteUser(@PathVariable("id") String id){
        userService.deleteUser(id);
    }
}

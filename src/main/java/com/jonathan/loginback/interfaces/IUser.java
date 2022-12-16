package com.jonathan.loginback.interfaces;

import com.jonathan.loginback.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface IUser {

    User saveUser(User user);

    Optional<User> findUserById(String id);

    Iterable<User> findUsers();

    void deleteUser(String Id);
}

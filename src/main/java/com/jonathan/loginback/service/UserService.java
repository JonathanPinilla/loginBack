package com.jonathan.loginback.service;

import com.jonathan.loginback.interfaces.IUser;
import com.jonathan.loginback.model.User;
import com.jonathan.loginback.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService implements IUser {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        try{
            return userRepository.save(user);
        } catch (Exception error) {
            throw new IllegalArgumentException(error);
        }
    }

    @Override
    public Optional<User> findUserById(String id) {
        try{
            return userRepository.findById(id);
        } catch (Exception error) {
            throw new IllegalArgumentException(error);
        }
    }

    @Override
    public Optional<User> loginUser(String email, String password) {
        try{
            Optional<User> foundByEmail = userRepository.findByEmail(email);
            if(Objects.equals(foundByEmail.get().getPassword(), password)){
                foundByEmail.get().setLoginDate(LocalDateTime.now());
                userRepository.save(foundByEmail.get());
                return foundByEmail;
            }
            throw new IllegalArgumentException("Wrong email or password");
        }catch (Exception error){
            throw new IllegalArgumentException("Wrong email or password");
        }
    }

    @Override
    public Iterable<User> findUsers() {
        try{
            return userRepository.findAll();
        } catch (Exception error) {
            throw new IllegalArgumentException(error);
        }
    }

    @Override
    public void deleteUser(String id) {
        try{
            Optional<User> deletedUser = userRepository.findById(id);
            deletedUser.get().setActive(false);
            userRepository.save(deletedUser.get());
        } catch (Exception error) {
            throw new IllegalArgumentException(error);
        }
    }
}

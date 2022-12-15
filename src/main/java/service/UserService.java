package service;

import interfaces.IUser;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UserRepository;

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
            userRepository.deleteById(id);
        } catch (Exception error) {
            throw new IllegalArgumentException(error);
        }
    }
}

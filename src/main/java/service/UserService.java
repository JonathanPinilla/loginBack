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
    public User saveClient(User user) {
        try{
            return userRepository.save(user);
        } catch (Exception error) {
            throw new IllegalArgumentException(error);
        }
    }

    @Override
    public Optional<User> findClientById(String id) {
        try{
            return userRepository.findById(id);
        } catch (Exception error) {
            throw new IllegalArgumentException(error);
        }
    }

    @Override
    public Iterable<User> findClients() {
        try{
            return userRepository.findAll();
        } catch (Exception error) {
            throw new IllegalArgumentException(error);
        }
    }

    @Override
    public void deleteClient(String id) {
        try{
            userRepository.deleteById(id);
        } catch (Exception error) {
            throw new IllegalArgumentException(error);
        }
    }
}

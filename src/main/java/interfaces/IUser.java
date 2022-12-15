package interfaces;

import model.User;

import java.util.Optional;

public interface IUser {
    User saveUser(User user);

    Optional<User> findUserById(String id);

    Iterable<User> findUsers();

    void deleteUser(String Id);
}

package interfaces;

import model.User;

import java.util.Optional;

public interface IUser {
    User saveClient(User client);

    Optional<User> findClientById(String Id);

    Iterable<User> findClients();

    void deleteClient(String Id);
}

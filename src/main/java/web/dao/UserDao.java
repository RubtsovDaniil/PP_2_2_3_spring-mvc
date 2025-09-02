package web.dao;

import web.model.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {

    User saveUser(User user);

    void deleteUser(User user);

    Optional<User> getUser(long id);

    List<User> getAllUsers();

    User updateUser(User user);
}

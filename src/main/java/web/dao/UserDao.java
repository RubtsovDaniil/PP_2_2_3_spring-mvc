package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {

    User saveUser(User user);

    void deleteUser(User user);

    User getUser(long id);

    List<User> getAllUsers();

    User updateUser(User user);
}

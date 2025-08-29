package web.service;

import web.model.User;

import java.util.List;


public interface UserService {

    User saveUser(User user);

    void deleteUser(long id);

    User getUser(long id);

    User updateUser(long id, User user);

    List<User> getAllUsers();

}

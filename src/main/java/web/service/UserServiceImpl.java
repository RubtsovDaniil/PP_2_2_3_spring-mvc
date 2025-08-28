package web.service;


import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.model.User;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Transactional
    public void deleteUser(long id) {
        userDao.deleteUser(id);
    }

    @Transactional
    public User getUser(long id) {
        return userDao.getUser(id);
    }

    @Transactional
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

}

package web.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;


import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public User saveUser(User user) {
        return userDao.saveUser(user);
    }

    @Override
    @Transactional
    public void deleteUser(long id) {
        User user = getUser(id);
        userDao.deleteUser(user);
    }

    @Override
    public User getUser(long id) {
        if (userDao.getUser(id) != null) {
            return userDao.getUser(id);
        } else {
            throw new EntityNotFoundException("Пользователь с ID " + id + " не найден");
        }
    }

    @Override
    @Transactional
    public User updateUser(long id, User user) {
        User existingUser = getUser(id);
        existingUser.setName(user.getName());
        existingUser.setLastName(user.getLastName());
        existingUser.setAge(user.getAge());
        return userDao.updateUser(existingUser);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

}

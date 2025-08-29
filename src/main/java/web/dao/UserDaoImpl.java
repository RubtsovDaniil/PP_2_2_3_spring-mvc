package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;
import web.service.UserService;
import web.service.UserServiceImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager em;

    public UserDaoImpl() {
    }

    @Override
    public User saveUser(User user) {
        em.persist(user);
        return user;
    }

    @Override
    public void deleteUser(User user) {
        em.remove(user);
    }

    @Override
    public User getUser(long id) {
        return em.find(User.class, id);
    }

    @Override
    public List<User> getAllUsers() {
        return em.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    @Override
    public User updateUser(User user) {
        return em.merge(user);
    }

}

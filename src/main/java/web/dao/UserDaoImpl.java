package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

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
    public Optional<User> getUser(long id) {
        return Optional.ofNullable(em.find(User.class, id));}

    @Override
    public List<User> getAllUsers() {
        return em.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    @Override
    public User updateUser(User user) {
        return em.merge(user);
    }

}

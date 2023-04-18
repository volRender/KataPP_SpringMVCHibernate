package mvcHiber.dao;

import mvcHiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {
    @PersistenceContext(type=PersistenceContextType.EXTENDED)
    private EntityManager em;

    @Override
    public List<User> allUsers() {
        TypedQuery<User> query = em.createQuery("SELECT u FROM User u", User.class);
        return query.getResultList();
    }

    @Override
    public void addUser(User user) {
        em.persist(user);
        System.out.println("User with name: " + user.getFirstName() + " was added in db");
    }

    @Override
    public User getUser(Long id) {
        return em.find(User.class, id);
    }

    @Override
    public void updateUser(User user, Long id) {
        em.merge(user);
    }

    @Override
    public void deleteUser(Long id) {
        em.remove(getUser(id));
    }

}

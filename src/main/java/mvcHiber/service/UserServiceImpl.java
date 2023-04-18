package mvcHiber.service;

import mvcHiber.dao.UserDAOImpl;
import mvcHiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service

public class UserServiceImpl implements UserService {

    private UserDAOImpl userDAO = new UserDAOImpl();

    @Autowired
    public void setUserDAO(UserDAOImpl userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    @Transactional
    public List<User> allUsers() {
        return userDAO.allUsers();
    }

    @Override
    @Transactional
    public void addUser(User user) {
        userDAO.addUser(user);
    }

    @Override
    @Transactional
    public User getUser(Long id) {
        return userDAO.getUser(id);
    }

    @Override
    @Transactional
    public void updateUser(User user, Long id) {
        userDAO.updateUser(user, id);
    }

    @Override
    public void deleteUser(Long id) {
        userDAO.deleteUser(id);
    }

}

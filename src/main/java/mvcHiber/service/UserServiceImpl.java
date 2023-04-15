package mvcHiber.service;

import mvcHiber.dao.UserDAOImpl;
import mvcHiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service

public class UserServiceImpl implements UserService {

    @Autowired
    UserDAOImpl userDAO;

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
}

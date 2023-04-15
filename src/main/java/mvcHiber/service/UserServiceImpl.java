package mvcHiber.service;

import mvcHiber.dao.UserDAOImpl;
import mvcHiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAOImpl userDAO;

    @Override
    public List<User> allUsers() {
        return userDAO.allUsers();
    }
}

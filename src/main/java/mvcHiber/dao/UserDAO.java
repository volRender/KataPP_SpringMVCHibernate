package mvcHiber.dao;

import mvcHiber.model.User;

import java.util.List;

public interface UserDAO {
    List<User> allUsers();
    void addUser(User user);
    void updateUser(User user, Long id);
    User getUser(Long id);
}

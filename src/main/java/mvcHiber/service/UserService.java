package mvcHiber.service;

import mvcHiber.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<User> allUsers();
}

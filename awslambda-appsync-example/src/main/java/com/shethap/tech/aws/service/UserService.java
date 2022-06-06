package com.shethap.tech.aws.service;

import com.shethap.tech.aws.dao.UserDAO;
import com.shethap.tech.aws.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public List<User> getUsers() {
        return userDAO.getUsers();
    }

    public User saveUser(User user) {
        return userDAO.saveUsers(user);
    }

    public List<User> getUserById(Integer userId) {
        return userDAO.getUsers().stream().filter(user -> user.getId() == userId).collect(Collectors.toList());
    }
}

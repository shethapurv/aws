package com.shethap.tech.aws.dao;

import com.shethap.tech.aws.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDAO {

    private List<User> userList;

    public UserDAO() {
        User user = new User();
        user.setId(1);
        user.setName("Apurv");
        if (!CollectionUtils.isEmpty(userList)) {
            userList.add(user);
        } else {
            userList = new ArrayList<>();
            userList.add(user);
        }
    }

    public List<User> getUsers() {
        return this.userList;
    }

    public User saveUsers(User user) {
        user.setId(userList.size() + 1);
        userList.add(user);
        return user;
    }
}

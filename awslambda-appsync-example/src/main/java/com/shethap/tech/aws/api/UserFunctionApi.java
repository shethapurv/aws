package com.shethap.tech.aws.api;

import com.shethap.tech.aws.model.User;
import com.shethap.tech.aws.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

@Component
public class UserFunctionApi {

    UserService userService;

    public UserFunctionApi(UserService userService) {
        this.userService = userService;
    }

    /**
     * saveUser implementation.
     *  http://localhost:8080/saveUser -H "Content-Type: application/json" -d "{\"name\": \"Paras\"}"
     * @return Function
     */
    @Bean
    public Function<User, String> saveUser() {
        return (user) -> {
            User addedUser = userService.saveUser(user);
            return "User with name" + addedUser.getName() + " saved with id " + String.valueOf(addedUser.getId());
        };
    }


    /**
     * getUserById implementation.
     * curl http://localhost:8080/getUserById -H "Content-Type: application/json" -d 1
     * @return Consumer
     */
    @Bean
    public Function<Integer, List<User>> getUserById() {
        return (userId) -> userService.getUserById(userId);
    }

    /**
     * getAllUsers implementation
     * http://localhost:8080/getAllUsers
     * @return Supplier
     */
    @Bean
    public Supplier<List<User>> getAllUsers() {
        return () -> userService.getUsers();
    }
}

package com.example.demo.Controller;

import com.example.demo.Models.User;
import com.example.demo.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/createuser", consumes = MediaType.APPLICATION_JSON_VALUE)
    public User testRequest(@RequestBody User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        user.setPassword(password);
        user.setUsername(username);
        userService.createUser(user);
        return user;
    }

    @GetMapping("/users")
    public List<User> getAllExercises() {
        return userService.getALlUsers();
    }
}

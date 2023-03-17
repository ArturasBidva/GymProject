package com.example.demo.Controller;

import com.example.demo.Models.User;
import com.example.demo.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/createuser", consumes = MediaType.APPLICATION_JSON_VALUE)
    public User testRequest(@RequestBody User user) {
        String username = user.getUsername();
        String name = user.getName();
        String password = user.getPassword();
        String surname = user.getSurname();
        String imgUrl = user.getImgUrl();
        user.setName(name);
        user.setPassword(password);
        user.setSurname(surname);
        user.setImgUrl(imgUrl);
        user.setUsername(username);
        userService.updateUser(user.getId(), user);
        System.out.println("gggg");
        return user;
    }
}

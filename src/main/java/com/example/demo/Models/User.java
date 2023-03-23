package com.example.demo.Models;

import com.example.demo.Entities.UserEntity;
import lombok.Data;

@Data
public class User {
    Long id;
    String username;
    String password;

    public User(UserEntity userEntity) {
        this.id = userEntity.getId();
        this.username = userEntity.getUsername();
        this.password = userEntity.getPassword();
    }
}
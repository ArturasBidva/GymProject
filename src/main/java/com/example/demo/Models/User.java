package com.example.demo.Models;

import com.example.demo.Entities.UserEntity;
import lombok.Data;

@Data
public class User {
    Long id;
    String name;
    String surname;
    String username;

    String imgUrl;

    String password;

    public User(UserEntity userEntity) {
        this.id = userEntity.getId();
        this.name = userEntity.getName();
        this.surname = userEntity.getSurname();
        this.username = userEntity.getUsername();
        this.imgUrl = userEntity.getImgUrl();
        this.password = userEntity.getPassword();
    }
}
package com.example.demo.Models;

import com.example.demo.Entities.UserEntity;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class User {
    Long id;
    String username;
    String password;

    public User() {} // default constructor

    @JsonCreator
    public User(@JsonProperty("id") Long id,
                @JsonProperty("username") String username,
                @JsonProperty("password") String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public User(UserEntity userEntity) {
        this.id = userEntity.getId();
        this.username = userEntity.getUsername();
        this.password = userEntity.getPassword();
    }
}
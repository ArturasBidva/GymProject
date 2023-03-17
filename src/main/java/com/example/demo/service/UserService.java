package com.example.demo.service;

import com.example.demo.Entities.UserEntity;
import com.example.demo.Models.User;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void deleteUser(Long id) {
        userRepository.delete(userRepository.getReferenceById(id));
    }

    public void updateUser(Long id, User user) {
        UserEntity referenceById = userRepository.getReferenceById(id);
        referenceById.setImgUrl(user.getImgUrl());
        referenceById.setName(user.getName());
        referenceById.setPassword(user.getPassword());
        userRepository.save(referenceById);
    }

    public User getUserById(Long id) {
        UserEntity userEntity = userRepository.getReferenceById(id);
        System.out.println("ggg");
        return new User(userEntity);
    }
}

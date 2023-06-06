package com.example.demo.service;

import com.example.demo.Entities.UserEntity;
import com.example.demo.Models.Exercise;
import com.example.demo.Models.User;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void deleteUser(Long id) {
        userRepository.delete(userRepository.getReferenceById(id));
    }

    public void createUser(User user) {
      UserEntity userEntity = new UserEntity();
      userEntity.setUsername(user.getUsername());
      userEntity.setPassword(user.getPassword());
        userRepository.save(userEntity);
        System.out.println("Ggg");
    }

    public User getUserById(Long id) {
        UserEntity userEntity = userRepository.getReferenceById(id);
        System.out.println("gge");
        return new User(userEntity);
    }

    public List<User> getALlUsers() {

        return userRepository.findAll()
                .stream()
                .map(User::new)
                .collect(Collectors.toList());
    }
}

package com.example.demo.Entities;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Data
@Table(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
}
package com.example.demo.Entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "gym_exercise_category")
public class ExerciseCategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String category;

  @ManyToMany(mappedBy = "exerciseCategory")
    private List<ExerciseEntity> exercises;
}

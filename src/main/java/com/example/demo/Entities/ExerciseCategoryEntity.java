package com.example.demo.Entities;

import com.example.demo.Models.ExerciseCategory;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
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

    public ExerciseCategoryEntity(ExerciseCategory exerciseCategory) {
        this.id = exerciseCategory.getId();
        this.category = exerciseCategory.getName();
        this.exercises = new ArrayList<>();
    }
    public ExerciseCategoryEntity() {

    }
}

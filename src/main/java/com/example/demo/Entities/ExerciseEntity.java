package com.example.demo.Entities;

import com.example.demo.Models.Exercise;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@Table(name = "gym_exercises")
public class ExerciseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private int weight;
    private String imgUrl;
    private String description;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "exercise_category",
            joinColumns = @JoinColumn(name = "exercise_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<ExerciseCategoryEntity> exerciseCategory;

    public ExerciseEntity(Exercise exercise) {
        this.id = exercise.getId();
        this.title = exercise.getTitle();
        this.weight = exercise.getWeight();
        this.imgUrl = exercise.getImgUrl();
        this.description = exercise.getDescription();
        this.exerciseCategory = exercise.getCategory().stream()
                .map(category -> {
                    ExerciseCategoryEntity categoryEntity = new ExerciseCategoryEntity();
                    categoryEntity.setId(category.getId());
                    categoryEntity.setCategory(category.getName());
                    return categoryEntity;
                }).collect(Collectors.toList());
    }
    public ExerciseEntity(){

    }
}
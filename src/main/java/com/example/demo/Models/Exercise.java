package com.example.demo.Models;

import com.example.demo.Entities.ExerciseEntity;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class Exercise {
    private Long id;
    private String title;
    private int weight;
    private String imgUrl;
    private String description;
    private List<ExerciseCategory> category;


    public Exercise(ExerciseEntity exerciseEntity) {
        this.id = exerciseEntity.getId();
        this.title = exerciseEntity.getTitle();
        this.weight = exerciseEntity.getWeight();
        this.imgUrl = exerciseEntity.getImgUrl();
        this.description = exerciseEntity.getDescription();
        this.category = exerciseEntity.getExerciseCategory().stream()
                .map(ExerciseCategory::new)
                .collect(Collectors.toList());

    }

    public Exercise() {

    }

}
package com.example.demo.Models;

import com.example.demo.Entities.ExerciseCategoryEntity;
import lombok.Data;

@Data
public class ExerciseCategory {
    Long id;
    String name;


    public ExerciseCategory(ExerciseCategoryEntity exerciseCategoryEntity){
        this.id = exerciseCategoryEntity.getId();
        this.name = exerciseCategoryEntity.getCategory();
    }
    public ExerciseCategory() {

    }
}


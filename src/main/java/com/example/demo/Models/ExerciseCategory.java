package com.example.demo.Models;

import com.example.demo.Entities.ExerciseCategoryEntity;
import lombok.Data;

@Data
public class ExerciseCategory {
    Long id;
    String category;


    public ExerciseCategory(ExerciseCategoryEntity exerciseCategoryEntity){
        this.id = exerciseCategoryEntity.getId();
        this.category = exerciseCategoryEntity.getCategory();
    }

    public ExerciseCategory() {

    }
}


package com.example.demo.Models;

import com.example.demo.Entities.ExerciseEntity;
import lombok.Data;

@Data
public class Exercise {
    private Long id;
    private String title;
    private int weight;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Exercise(ExerciseEntity exerciseEntity) {
        this.id = exerciseEntity.getId();
        this.title = exerciseEntity.getTitle();
        this.weight = exerciseEntity.getWeight();

    }

    public Exercise (){

    }

}

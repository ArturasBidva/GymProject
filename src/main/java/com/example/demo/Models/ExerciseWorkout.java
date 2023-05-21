package com.example.demo.Models;

import com.example.demo.Entities.ExerciseWorkoutEntity;
import lombok.Data;

@Data
public class ExerciseWorkout {
    Long id;
    private Exercise exercise;
    int completedCount = 0;
    int goal;
    public ExerciseWorkout(ExerciseWorkoutEntity exerciseWorkoutEntity) {
        this.id = exerciseWorkoutEntity.getId();
        this.exercise = new Exercise(exerciseWorkoutEntity.getExerciseEntity()); // Assuming you have an Exercise class with the required constructor.
        this.completedCount = exerciseWorkoutEntity.getCompletedCount();
        this.goal = exerciseWorkoutEntity.getGoal();
    }
    public ExerciseWorkout(){

    }
}

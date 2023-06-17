package com.example.demo.Models;

import com.example.demo.Entities.ExerciseWorkoutEntity;
import lombok.Data;

@Data
public class ExerciseWorkout {
    Long id;
    private Exercise exercise;
    int completedCount = 0;
    int goal;

    int weight = 0;

    public ExerciseWorkout(ExerciseWorkoutEntity exerciseWorkoutEntity) {
        this.id = exerciseWorkoutEntity.getId();
        this.exercise = new Exercise(exerciseWorkoutEntity.getExerciseEntity());
        this.completedCount = exerciseWorkoutEntity.getCompletedCount();
        this.goal = exerciseWorkoutEntity.getGoal();
        this.weight =exerciseWorkoutEntity.getWeight();
    }

    public ExerciseWorkout() {

    }
}

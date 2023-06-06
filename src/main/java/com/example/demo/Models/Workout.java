package com.example.demo.Models;

import com.example.demo.Entities.WorkoutEntity;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class Workout {
    Long id;
    String title;
    String description;
    List<ExerciseWorkout> exerciseWorkouts = new ArrayList<>();

    public Workout(WorkoutEntity workoutEntity) {
        this.id = workoutEntity.getId();
        this.title = workoutEntity.getTitle();
        this.description = workoutEntity.getDescription();
        this.exerciseWorkouts = workoutEntity.getExerciseWorkoutEntities()
                .stream().map(ExerciseWorkout::new)
                .collect(Collectors.toList());
    }

    public Workout() {

    }
}

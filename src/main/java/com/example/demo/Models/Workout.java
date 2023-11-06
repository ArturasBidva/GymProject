package com.example.demo.Models;

import com.example.demo.Entities.WorkoutEntity;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class Workout {
    Long id;
    String title;
    String description;
    LocalDate date = null;
    LocalTime startTime = null;
    LocalTime endTime = null;
    List<ExerciseWorkout> exerciseWorkouts = new ArrayList<>();

    public Workout(WorkoutEntity workoutEntity) {
        this.id = workoutEntity.getId();
        this.title = workoutEntity.getTitle();
        this.description = workoutEntity.getDescription();
        this.date = workoutEntity.getDate();
        this.startTime = workoutEntity.getStartTime();
        this.endTime = workoutEntity.getEndTime();
        this.exerciseWorkouts = workoutEntity.getExerciseWorkoutEntities()
                .stream().map(ExerciseWorkout::new)
                .collect(Collectors.toList());
    }

    public void addToExerciseWorkouts(ExerciseWorkout exerciseWorkout) {
        exerciseWorkouts.add(exerciseWorkout);
    }

    public Workout() {

    }
}

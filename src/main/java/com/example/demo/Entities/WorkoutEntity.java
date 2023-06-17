package com.example.demo.Entities;

import com.example.demo.Models.Workout;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@Table(name = "gym_workouts")
public class WorkoutEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String title;
    String description;
    @ManyToMany
    @JoinTable(name = "exerciseWorkout_workout",
            joinColumns = @JoinColumn(name = "workout_id"),
            inverseJoinColumns = @JoinColumn(name = "exercise_workout_id"))
    List<ExerciseWorkoutEntity> exerciseWorkoutEntities = new ArrayList<>();

    public WorkoutEntity() {
    }

    public WorkoutEntity(Workout workout) {
        this.id = workout.getId();
        this.title = workout.getTitle();
        this.description = workout.getDescription();
        this.exerciseWorkoutEntities = workout.getExerciseWorkouts().stream()
                .map(ExerciseWorkoutEntity::new)
                .collect(Collectors.toList());
    }
}

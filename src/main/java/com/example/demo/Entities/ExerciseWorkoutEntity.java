package com.example.demo.Entities;

import com.example.demo.Models.ExerciseWorkout;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "gym_exercise_workout")
public class ExerciseWorkoutEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "workout_id")
    private WorkoutEntity workoutEntity;

    @ManyToOne
    @JoinColumn(name = "exercise_entity_id")
    private ExerciseEntity exerciseEntity;
    int completedCount = 0;
    int goal;

    public ExerciseWorkoutEntity(ExerciseWorkout exerciseWorkout) {
        this.id = exerciseWorkout.getId();
        this.completedCount = exerciseWorkout.getCompletedCount();
        this.goal = exerciseWorkout.getGoal();
        this.exerciseEntity = new ExerciseEntity(exerciseWorkout.getExercise());
    }

    public ExerciseWorkoutEntity() {

    }
}


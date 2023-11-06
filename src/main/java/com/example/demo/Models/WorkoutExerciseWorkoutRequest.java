package com.example.demo.Models;

public class WorkoutExerciseWorkoutRequest {
    private Long workoutId;

    public ExerciseWorkout getExerciseWorkout() {
        return exerciseWorkout;
    }

    public Long getWorkoutId() {
        return workoutId;
    }

    public void setExerciseWorkout(ExerciseWorkout exerciseWorkout) {
        this.exerciseWorkout = exerciseWorkout;
    }

    ExerciseWorkout exerciseWorkout;

    public WorkoutExerciseWorkoutRequest(Long workoutId, ExerciseWorkout exerciseWorkout) {
        this.workoutId = workoutId;
        this.exerciseWorkout = exerciseWorkout;
    }
}

package com.example.demo.Controller;

import com.example.demo.Models.Exercise;
import com.example.demo.Models.ExerciseWorkout;
import com.example.demo.Models.Workout;
import com.example.demo.service.ExerciseService;
import com.example.demo.service.ExerciseWorkoutService;
import com.example.demo.service.WorkoutService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExerciseWorkoutController {
    ExerciseWorkoutService exerciseWorkoutService;
    ExerciseService exerciseService;
    WorkoutService workoutService;

    ExerciseWorkoutController(ExerciseWorkoutService exerciseWorkoutService, ExerciseService exerciseService,WorkoutService workoutService) {
        this.exerciseWorkoutService = exerciseWorkoutService;
        this.exerciseService = exerciseService;
        this.workoutService = workoutService;
    }

    @PostMapping(value = "/exerciseworkout", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ExerciseWorkout createExerciseWorkout(@RequestBody ExerciseWorkout exerciseWorkout) {
        Exercise exerciseById = exerciseService.getExerciseById(exerciseWorkout.getExercise().getId());
        int goal = exerciseWorkout.getGoal();
        ExerciseWorkout exerciseWorkout1 = new ExerciseWorkout();
        exerciseWorkout1.setExercise(exerciseById);
        exerciseWorkout1.setGoal(goal);
        exerciseWorkoutService.createWorkoutExercise(exerciseWorkout1);
        return exerciseWorkout1;
    }
}

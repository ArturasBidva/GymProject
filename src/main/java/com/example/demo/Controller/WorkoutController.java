package com.example.demo.Controller;

import com.example.demo.Models.Workout;
import com.example.demo.Models.WorkoutExerciseWorkoutRequest;
import com.example.demo.service.ExerciseWorkoutService;
import com.example.demo.service.WorkoutService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WorkoutController {
    WorkoutService workoutService;
    ExerciseWorkoutService exerciseWorkoutService;

    public WorkoutController(WorkoutService workoutService, ExerciseWorkoutService exerciseWorkoutService) {
        this.workoutService = workoutService;
        this.exerciseWorkoutService = exerciseWorkoutService;
    }

    @PostMapping(value = "/workout", consumes = MediaType.APPLICATION_JSON_VALUE)
    Workout createWorkout(@RequestBody Workout workout) {
        Workout newWorkout = new Workout();
        newWorkout.setTitle(workout.getTitle());
        newWorkout.setDescription(workout.getDescription());
        workoutService.createWorkoutData(newWorkout);
        return newWorkout;
    }

    @GetMapping(value = "/workouts")
    List<Workout> getAllWorkouts() {
        return workoutService.getALlWorkouts();
    }

    @PostMapping(value = "/add/workout/exerciseworkout", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addExerciseWorkoutToWorkout(@RequestBody WorkoutExerciseWorkoutRequest request) {
        workoutService.addExerciseWorkoutToWorkout(
                request.getWorkoutId(),
                request.getExerciseWorkout()
        );
    }

    @DeleteMapping(value = "/all/workouts")
    public void deleteAllWorkouts() {
        workoutService.deleteAllWorkouts();
    }

    @GetMapping(value = "/get/workout/{id}")
    Workout getWorkoutById(@PathVariable Long id) {
        return workoutService.getWorkoutById(id);
    }


    @DeleteMapping(value = "/delete/workout/{id}")
    public void deleteWorkoutById(@PathVariable Long id) {
        workoutService.deleteWorkoutById(id);
    }


}

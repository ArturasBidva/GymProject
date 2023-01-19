package com.example.demo.Controller;

import com.example.demo.Models.Exercise;
import com.example.demo.service.ExerciseService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExerciseController {

    ExerciseService exerciseService;

    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @PostMapping(value = "/exercise", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Exercise testRequest(@RequestBody Exercise exercise) {
        String title = exercise.getTitle();
        int weight = exercise.getWeight();
        exercise.setTitle(title);
        exercise.setWeight(weight);
        exerciseService.saveData(exercise);
        return exercise;
    }

    @GetMapping("/exercises")
    public List<Exercise> getAllExercises() {
        return exerciseService.getALlProducts();
    }

    @DeleteMapping("/exercise/{id}")
    public void deleteExercise(@PathVariable Long id) {
        exerciseService.deleteExercise(id);
    }

    @PostMapping(value = "/exercise/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateExercise(@PathVariable Long id, @RequestBody Exercise exercise){
        String title = exercise.getTitle();
        int weight = exercise.getWeight();
        Exercise exercise1 = new Exercise();
        exercise1.setTitle(title);
        exercise1.setWeight(weight);
        exerciseService.updateExercise(id,exercise1);
    }
    @GetMapping("/exercise/get/{id}")
    public Exercise getExerciseById(@PathVariable Long id){
      return exerciseService.getExerciseById(id);
    }
}

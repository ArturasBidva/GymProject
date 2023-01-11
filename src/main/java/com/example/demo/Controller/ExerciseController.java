package com.example.demo.Controller;

import com.example.demo.Models.Exercise;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.ExerciseService;

import java.util.List;

@RestController
public class ExerciseController {

    ExerciseService exerciseService;

    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @PostMapping(value = "/exer", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Exercise testRequest(@RequestBody Exercise exercise){
        String title = exercise.getTitle();
        int weight = exercise.getWeight();
        exercise.setTitle(title);
        exercise.setWeight(weight);
        exerciseService.saveData(exercise);
        return exercise;
    }

    @GetMapping("/exercises")
    public List<Exercise> getAllExercises(){
return exerciseService.getALlProducts();
    }
    @DeleteMapping("/exercise/{id}")
    public void deleteExercise(@PathVariable Long id){
        exerciseService.deleteExercise(id);
    }
}

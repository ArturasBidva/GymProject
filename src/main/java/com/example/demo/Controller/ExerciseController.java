package com.example.demo.Controller;

import com.example.demo.Models.Exercise;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.service.ExerciseService;

@RestController
public class ExerciseController {

    ExerciseService exerciseService;

    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @GetMapping("/exer")
    public Exercise testRequest(){
        Exercise exercise = new Exercise();
        exercise.setTitle("Labas");
        exercise.setWeight(100);
        exerciseService.saveData(exercise);
        return exercise;
    }

}

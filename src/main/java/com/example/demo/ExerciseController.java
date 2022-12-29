package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExerciseController {

    @GetMapping("/exer")
    public Exercise testRequest(){
        Exercise exercise = new Exercise();
        exercise.setTitle("Labas");
        exercise.setWeight(100);
        return exercise;
    }
}

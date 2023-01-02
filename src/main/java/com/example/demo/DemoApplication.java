package com.example.demo;

import com.example.demo.Models.Exercise;
import com.example.demo.service.ExerciseService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class DemoApplication {
    static ExerciseService exerciseService;

    @Autowired
    public DemoApplication(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
		DemoApplication.mockThisData();
    }

    public static void mockThisData() {
        Exercise exercise = new Exercise();
        exercise.setTitle("Belekas");
        exercise.setWeight(100);
        exerciseService.saveData(exercise);
    }

}

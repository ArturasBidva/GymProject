package com.example.demo;

import com.example.demo.Models.Exercise;
import com.example.demo.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
        exercise.setDescription("vaziuojam dzesika 2000");
        exercise.setImgUrl("https://post.healthline.com/wp-content/uploads/2020/02/man-exercising-plank-push-up-1200x628-facebook.jpg");
        exerciseService.saveData(exercise);
    }

}

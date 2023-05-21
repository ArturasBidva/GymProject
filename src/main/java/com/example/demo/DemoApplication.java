package com.example.demo;

import com.example.demo.Models.Exercise;
import com.example.demo.Models.ExerciseCategory;
import com.example.demo.Models.ExerciseWorkout;
import com.example.demo.service.ExerciseCategoryService;
import com.example.demo.service.ExerciseService;
import com.example.demo.service.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class DemoApplication {
    static ExerciseService exerciseService;
    static ExerciseCategoryService exerciseCategoryService;
    static WorkoutService workoutService;

    @Autowired
    public DemoApplication(ExerciseService exerciseService
            , ExerciseCategoryService exerciseCategoryService
            , WorkoutService workoutService) {
        this.exerciseService = exerciseService;
        this.exerciseCategoryService = exerciseCategoryService;
        this.workoutService = workoutService;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        //DemoApplication.mockThisData();
        //DemoApplication.mockThisDataTwo();
        //DemoApplication.createMockExerciseCategories();

    }


    public static void mockThisData() {
        Exercise exercise = new Exercise();
        exercise.setTitle("Exercise Title 1");
        exercise.setWeight(1000);
        exercise.setDescription("vaziuojam dzesika 2000");
        exercise.setImgUrl("https://post.healthline.com/wp-content/uploads/2020/02/man-exercising-plank-push-up-1200x628-facebook.jpg");

        ExerciseCategory category1 = new ExerciseCategory();
        category1.setCategory("Bicepsas");

        ExerciseCategory category2 = new ExerciseCategory();
        category2.setCategory("Kojos");

        exercise.setCategory(Arrays.asList(category1, category2));
        ExerciseWorkout exerciseWorkout = new ExerciseWorkout();
        exerciseWorkout.setCompletedCount(0);
        exerciseWorkout.setGoal(4);
        exerciseService.saveData(exercise);
        exerciseWorkout.setExercise(exerciseService.getExerciseById(exercise.getId()));

    }

    public static void mockThisDataTwo() {
        Exercise exercise = new Exercise();
        exercise.setTitle("Exercise Title 2");
        exercise.setWeight(100);
        exercise.setDescription("vaziuojam dzesika 2000");
        exercise.setImgUrl("https://post.healthline.com/wp-content/uploads/2020/02/man-exercising-plank-push-up-1200x628-facebook.jpg");

        ExerciseCategory category1 = new ExerciseCategory();
        category1.setCategory("Tricepsas");

        exercise.setCategory(List.of(category1));

        exerciseService.saveData(exercise);
    }

//    public static void createMockExerciseCategories() {
//
//        ExerciseCategory category1 = new ExerciseCategory();
//        category1.setCategory("Biceps");
//        exerciseCategoryService.saveCategory(category1);
//
//        ExerciseCategory category2 = new ExerciseCategory();
//        category2.setCategory("Triceps");
//        exerciseCategoryService.saveCategory(category2);
//
//        ExerciseCategory category3 = new ExerciseCategory();
//        category3.setCategory("Chest");
//        exerciseCategoryService.saveCategory(category3);
//
//        ExerciseCategory category4 = new ExerciseCategory();
//        category4.setCategory("Back");
//        exerciseCategoryService.saveCategory(category4);
//
//        ExerciseCategory category5 = new ExerciseCategory();
//        category5.setCategory("Legs");
//        exerciseCategoryService.saveCategory(category5);
//
//        ExerciseCategory category6 = new ExerciseCategory();
//        category6.setCategory("Shoulders");
//        exerciseCategoryService.saveCategory(category6);
//
//        ExerciseCategory category7 = new ExerciseCategory();
//        category7.setCategory("Abs");
//        exerciseCategoryService.saveCategory(category7);
//
//    }

}


package com.example.demo.Controller;

import com.example.demo.Models.ExerciseCategory;
import com.example.demo.service.ExerciseCategoryService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExerciseCategoryController {
    ExerciseCategoryService exerciseCategoryService;

    ExerciseCategoryController(ExerciseCategoryService exerciseCategoryService) {
        this.exerciseCategoryService = exerciseCategoryService;
    }

    @PostMapping(value = "/category", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ExerciseCategory createCategory(@RequestBody ExerciseCategory exerciseCategory) {
        String category = exerciseCategory.getCategory();
        exerciseCategory.setCategory(category);
        exerciseCategoryService.saveCategory(exerciseCategory);
        return exerciseCategory;
    }

    @GetMapping(value = "/categories")
    public List<ExerciseCategory> getExerciseCategories() {
        return exerciseCategoryService.getALlCategories();
    }

    @GetMapping("/category/get/{id}")
    public ExerciseCategory getExerciseById(@PathVariable Long id) {
        return exerciseCategoryService.getExerciseCategoryById(id);
    }

}

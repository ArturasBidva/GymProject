package com.example.demo.service;

import com.example.demo.Entities.ExerciseCategoryEntity;
import com.example.demo.Models.ExerciseCategory;
import com.example.demo.repository.ExerciseCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExerciseCategoryService {
    ExerciseCategoryRepository exerciseCategoryRepository;

    ExerciseCategoryService (ExerciseCategoryRepository exerciseCategoryRepository) {
        this.exerciseCategoryRepository = exerciseCategoryRepository;
    }
    public void saveCategory(ExerciseCategory exerciseCategory) {
        ExerciseCategoryEntity exerciseCategoryEntity = new ExerciseCategoryEntity();
        exerciseCategoryEntity.setCategory(exerciseCategory.getCategory());
        exerciseCategoryRepository.save(exerciseCategoryEntity);
    }
    public List<ExerciseCategory> getALlCategories() {

        return exerciseCategoryRepository.findAll()
                .stream()
                .map(ExerciseCategory::new)
                .collect(Collectors.toList());
    }
    public ExerciseCategory getExerciseCategoryById(Long id) {
        ExerciseCategoryEntity exerciseCategoryEntity = exerciseCategoryRepository.getReferenceById(id);
        System.out.println(exerciseCategoryEntity);
        return new ExerciseCategory(exerciseCategoryEntity);
    }
}

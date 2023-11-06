package com.example.demo.service;

import com.example.demo.Entities.ExerciseCategoryEntity;
import com.example.demo.Models.ExerciseCategory;
import com.example.demo.repository.ExerciseCategoryRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExerciseCategoryService {

    ExerciseCategoryRepository exerciseCategoryRepository;

    ExerciseCategoryService(ExerciseCategoryRepository exerciseCategoryRepository) {
        this.exerciseCategoryRepository = exerciseCategoryRepository;
    }

    public void saveCategory() {
        ExerciseCategoryEntity exerciseCategoryone = new ExerciseCategoryEntity();
        exerciseCategoryone.setCategory("Legs");
        ExerciseCategoryEntity exerciseCategorytwo = new ExerciseCategoryEntity();
        exerciseCategorytwo.setCategory("Shoulders");
        ExerciseCategoryEntity exerciseCategorythree = new ExerciseCategoryEntity();
        exerciseCategorythree.setCategory("Back");
        ExerciseCategoryEntity exerciseCategoryfour = new ExerciseCategoryEntity();
        exerciseCategoryfour.setCategory("Chest");
        ExerciseCategoryEntity exerciseCategoryfive = new ExerciseCategoryEntity();
        exerciseCategoryfive.setCategory("Arms");
        ExerciseCategoryEntity exerciseCategorysix = new ExerciseCategoryEntity();
        exerciseCategorysix.setCategory("Full body");
        List<ExerciseCategoryEntity> exerciseCategoryEntityList = new ArrayList<>();
        exerciseCategoryEntityList.add(exerciseCategoryone);
        exerciseCategoryEntityList.add(exerciseCategorytwo);
        exerciseCategoryEntityList.add(exerciseCategorythree);
        exerciseCategoryEntityList.add(exerciseCategoryfour);
        exerciseCategoryEntityList.add(exerciseCategoryfive);
        exerciseCategoryEntityList.add(exerciseCategorysix);

        exerciseCategoryRepository.saveAll(exerciseCategoryEntityList);
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

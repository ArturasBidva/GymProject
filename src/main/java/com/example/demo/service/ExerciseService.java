package com.example.demo.service;

import com.example.demo.Entities.ExerciseCategoryEntity;
import com.example.demo.Entities.ExerciseEntity;
import com.example.demo.Models.Exercise;
import com.example.demo.repository.ExerciseCategoryRepository;
import com.example.demo.repository.ExerciseRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExerciseService {
    ExerciseRepository exerciseRepository;
    ExerciseCategoryRepository exerciseCategoryRepository;

    public ExerciseService(ExerciseRepository exerciseRepository, ExerciseCategoryRepository exerciseCategoryRepository) {
        this.exerciseRepository = exerciseRepository;
        this.exerciseCategoryRepository = exerciseCategoryRepository;
    }

    public void saveData(Exercise exercise) {
        ExerciseEntity exerciseEntity = new ExerciseEntity();
        exerciseEntity.setTitle(exercise.getTitle());
        exerciseEntity.setWeight(exercise.getWeight());
        exerciseEntity.setImgUrl(exercise.getImgUrl());
        exerciseEntity.setDescription(exercise.getDescription());
        List<ExerciseCategoryEntity> categoryEntities = exercise.getCategory().stream()
                .map(category -> {
                    ExerciseCategoryEntity categoryEntity = new ExerciseCategoryEntity();
                    categoryEntity.setId(category.getId());
                    categoryEntity.setCategory(category.getCategory());
                    return exerciseCategoryRepository.save(categoryEntity);
                }).toList();

        exerciseEntity.setExerciseCategory(categoryEntities);
        exerciseRepository.save(exerciseEntity);
        System.out.println("Ggg");
    }

    @Transactional
    public void deleteExercise(Long id) {
        ExerciseEntity exerciseEntity = exerciseRepository.findById(id).orElseThrow(() -> new RuntimeException("Exercise not found"));
        for (ExerciseCategoryEntity category : exerciseEntity.getExerciseCategory()) {
            category.getExercises().remove(exerciseEntity);
        }
        exerciseEntity.getExerciseCategory().clear();

        exerciseRepository.save(exerciseEntity);
        exerciseRepository.deleteById(id);
    }

    public List<Exercise> getALlExercises() {

        return exerciseRepository.findAll()
                .stream()
                .map(Exercise::new)
                .collect(Collectors.toList());
    }

    public void updateExercise(Long id, Exercise exercise) {
        ExerciseEntity referenceById = exerciseRepository.getReferenceById(id);
        referenceById.setTitle(exercise.getTitle());
        referenceById.setWeight(exercise.getWeight());
        referenceById.setImgUrl(exercise.getImgUrl());
        referenceById.setDescription(exercise.getDescription());
        exerciseRepository.save(referenceById);
    }

    public Exercise getExerciseById(Long id) {
        ExerciseEntity exerciseEntity = exerciseRepository.getReferenceById(id);
        System.out.println("ggggg");
        return new Exercise(exerciseEntity);
    }

}

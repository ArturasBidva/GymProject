package com.example.demo.service;

import com.example.demo.Entities.ExerciseEntity;
import com.example.demo.Models.Exercise;
import com.example.demo.repository.ExerciseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExerciseService {
    ExerciseRepository exerciseRepository;

    public ExerciseService(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    public void saveData(Exercise exercise) {
        ExerciseEntity exerciseEntity = new ExerciseEntity();
        exerciseEntity.setTitle(exercise.getTitle());
        exerciseEntity.setWeight(exercise.getWeight());
        exerciseEntity.setImgUrl(exercise.getImgUrl());
        exerciseEntity.setDescription(exercise.getDescription());
        exerciseRepository.save(exerciseEntity);
    }

    public void deleteExercise(Long id) {
        exerciseRepository.delete(exerciseRepository.getReferenceById(id));
    }

    public List<Exercise> getALlProducts() {

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

package com.example.demo.service;

import com.example.demo.Entities.ExerciseEntity;
import com.example.demo.Models.Exercise;
import org.springframework.stereotype.Service;
import com.example.demo.repository.ExerciseRepository;
@Service
public class ExerciseService {
    ExerciseRepository exerciseRepository;
    public ExerciseService(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    public void saveData(Exercise exercise){
        ExerciseEntity exerciseEntity = new ExerciseEntity();
        exerciseEntity.setTitle(exercise.getTitle());
        exerciseEntity.setWeight(exercise.getWeight());
        exerciseRepository.save(exerciseEntity);
    }

}

package com.example.demo.service;

import com.example.demo.Entities.ExerciseEntity;
import com.example.demo.Models.Exercise;
import org.springframework.stereotype.Service;
import com.example.demo.repository.ExerciseRepository;

import java.util.List;
import java.util.stream.Collectors;

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
    public void deleteExercise(Long id){
        exerciseRepository.delete(exerciseRepository.getReferenceById(id));
    }
    public List<Exercise> getALlProducts() {

        return exerciseRepository.findAll()
                .stream()
                .map(Exercise::new)
                .collect(Collectors.toList());
    }

}

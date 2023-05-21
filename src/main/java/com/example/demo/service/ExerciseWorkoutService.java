package com.example.demo.service;

import com.example.demo.Entities.ExerciseEntity;
import com.example.demo.Entities.ExerciseWorkoutEntity;
import com.example.demo.Models.ExerciseWorkout;
import com.example.demo.repository.ExerciseCategoryRepository;
import com.example.demo.repository.ExerciseWorkoutRepository;
import org.springframework.stereotype.Service;

@Service
public class ExerciseWorkoutService {
    ExerciseWorkoutRepository exerciseWorkoutRepository;
    ExerciseCategoryRepository exerciseCategoryRepository;

    ExerciseWorkoutService(ExerciseWorkoutRepository exerciseWorkoutRepository,
                           ExerciseCategoryRepository exerciseCategoryRepository
    ) {
        this.exerciseWorkoutRepository = exerciseWorkoutRepository;
        this.exerciseCategoryRepository = exerciseCategoryRepository;
    }

    public void createWorkoutExercise(ExerciseWorkout exerciseWorkout) {
        ExerciseWorkoutEntity exerciseWorkoutEntity = new ExerciseWorkoutEntity();
        exerciseWorkoutEntity.setGoal(exerciseWorkout.getGoal());
        ExerciseEntity exerciseEntity = new ExerciseEntity();
        exerciseEntity.setId(exerciseWorkout.getExercise().getId());
        exerciseWorkoutEntity.setExerciseEntity(exerciseEntity);
        exerciseWorkoutRepository.save(exerciseWorkoutEntity);
    }

    public ExerciseWorkout getExerciseWorkoutById(Long id){
       ExerciseWorkoutEntity exerciseWorkoutEntity = exerciseWorkoutRepository.getReferenceById(id);
       return new ExerciseWorkout(exerciseWorkoutEntity);
    }

}

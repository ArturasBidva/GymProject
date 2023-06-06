package com.example.demo.service;

import com.example.demo.Entities.ExerciseEntity;
import com.example.demo.Entities.ExerciseWorkoutEntity;
import com.example.demo.Models.Exercise;
import com.example.demo.Models.ExerciseWorkout;
import com.example.demo.repository.ExerciseCategoryRepository;
import com.example.demo.repository.ExerciseWorkoutRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public ExerciseWorkout createExerciseWorkout(ExerciseWorkout exerciseWorkout) {
        ExerciseWorkoutEntity exerciseWorkoutEntity = new ExerciseWorkoutEntity();
        exerciseWorkoutEntity.setGoal(exerciseWorkout.getGoal());
        ExerciseEntity exerciseEntity = new ExerciseEntity();
        exerciseEntity.setId(exerciseWorkout.getExercise().getId());
        exerciseWorkoutEntity.setExerciseEntity(exerciseEntity);
        ExerciseWorkoutEntity savedEntity = exerciseWorkoutRepository.save(exerciseWorkoutEntity);

        ExerciseWorkout savedExerciseWorkout = new ExerciseWorkout();
        savedExerciseWorkout.setId(savedEntity.getId());
        savedExerciseWorkout.setGoal(savedEntity.getGoal());
        Exercise exercise = new Exercise();
        exercise.setId(savedEntity.getExerciseEntity().getId());
        savedExerciseWorkout.setExercise(exercise);

        return savedExerciseWorkout;
    }

    public void deleteExerciseWorkout(ExerciseWorkout exerciseWorkout) {
        ExerciseWorkoutEntity exerciseWorkoutEntity = exerciseWorkoutRepository.getReferenceById(exerciseWorkout.getId());
        exerciseWorkoutRepository.delete(exerciseWorkoutEntity);
    }

    public ExerciseWorkout getExerciseWorkoutById(Long id) {
        ExerciseWorkoutEntity exerciseWorkoutEntity = exerciseWorkoutRepository.getReferenceById(id);
        return new ExerciseWorkout(exerciseWorkoutEntity);
    }

    public ExerciseWorkoutEntity getExerciseWorkoutByIdEntity(Long id) {
        return exerciseWorkoutRepository.getReferenceById(id);
    }

    public List<ExerciseWorkout> getAllExerciseWorkout() {

        return exerciseWorkoutRepository.findAll()
                .stream()
                .map(ExerciseWorkout::new)
                .collect(Collectors.toList());
    }

}

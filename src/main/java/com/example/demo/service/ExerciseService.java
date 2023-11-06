package com.example.demo.service;

import com.example.demo.Entities.ExerciseCategoryEntity;
import com.example.demo.Entities.ExerciseEntity;
import com.example.demo.Models.Exercise;
import com.example.demo.Models.ExerciseWorkout;
import com.example.demo.Models.Workout;
import com.example.demo.repository.ExerciseCategoryRepository;
import com.example.demo.repository.ExerciseRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExerciseService {
    ExerciseRepository exerciseRepository;
    ExerciseCategoryRepository exerciseCategoryRepository;
    WorkoutService workoutService;
    ExerciseWorkoutService exerciseWorkoutService;

    public ExerciseService(ExerciseRepository exerciseRepository,
                           ExerciseCategoryRepository exerciseCategoryRepository,
                           WorkoutService workoutService, ExerciseWorkoutService exerciseWorkoutService) {
        this.exerciseRepository = exerciseRepository;
        this.exerciseCategoryRepository = exerciseCategoryRepository;
        this.workoutService = workoutService;
        this.exerciseWorkoutService = exerciseWorkoutService;
    }

    public Exercise saveData(Exercise exercise) {
        ExerciseEntity exerciseEntity = new ExerciseEntity();
        exerciseEntity.setTitle(exercise.getTitle());
        exerciseEntity.setWeight(exercise.getWeight());
        exerciseEntity.setImgUrl(exercise.getImgUrl());
        exerciseEntity.setDescription(exercise.getDescription());

        System.out.println("Exercise Saved");
        ExerciseCategoryEntity referenceById = exerciseCategoryRepository.getReferenceById(1L);
        ExerciseCategoryEntity referenceByIdtwo = exerciseCategoryRepository.getReferenceById(2L);
        List<ExerciseCategoryEntity> categoryList = new ArrayList<>();
        categoryList.add(referenceById);
        categoryList.add(referenceByIdtwo);
        exerciseEntity.setExerciseCategory(categoryList);
        ExerciseEntity save = exerciseRepository.save(exerciseEntity);
        Exercise exercise1 = new Exercise();
        exercise1.setTitle(save.getTitle());
        exercise1.setImgUrl(save.getImgUrl());
        exercise1.setDescription(save.getDescription());
        exercise1.setId(save.getId());

        return exercise1;
    }

    @Transactional
    public void deleteExercise(Long exerciseId) {
        List<Workout> allWorkouts = workoutService.getALlWorkouts();

        for (Workout workout : allWorkouts) {
            workout.getExerciseWorkouts().removeIf(exerciseWorkout ->
                    exerciseWorkout.getExercise().getId().equals(exerciseId));
            workoutService.updateWorkout(workout);
        }

        List<ExerciseWorkout> exerciseWorkoutsToDelete = exerciseWorkoutService.getExerciseWorkoutsByExerciseId(exerciseId);

        for (ExerciseWorkout exerciseWorkout : exerciseWorkoutsToDelete) {
            exerciseWorkoutService.deleteExerciseWorkout(exerciseWorkout);
        }

        ExerciseEntity referenceById = exerciseRepository.getReferenceById(exerciseId);
        exerciseRepository.delete(referenceById);
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
        System.out.println("Getting exercise by ID");
        return new Exercise(exerciseEntity);
    }
}
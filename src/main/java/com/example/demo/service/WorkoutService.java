package com.example.demo.service;

import com.example.demo.Entities.ExerciseWorkoutEntity;
import com.example.demo.Entities.WorkoutEntity;
import com.example.demo.Models.Workout;
import com.example.demo.repository.ExerciseCategoryRepository;
import com.example.demo.repository.ExerciseRepository;
import com.example.demo.repository.ExerciseWorkoutRepository;
import com.example.demo.repository.WorkoutRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WorkoutService {

    WorkoutRepository workoutRepository;
    ExerciseRepository exerciseRepository;
    ExerciseCategoryRepository exerciseCategoryRepository;

    ExerciseWorkoutRepository exerciseWorkoutRepository;

    ExerciseWorkoutService exerciseWorkoutService;

    WorkoutService(WorkoutRepository workoutRepository,
                   ExerciseRepository exerciseRepository,
                   ExerciseCategoryRepository exerciseCategoryRepository,
                   ExerciseWorkoutRepository exerciseWorkoutRepository, ExerciseWorkoutService exerciseWorkoutService) {
        this.workoutRepository = workoutRepository;
        this.exerciseRepository = exerciseRepository;
        this.exerciseCategoryRepository = exerciseCategoryRepository;
        this.exerciseWorkoutRepository = exerciseWorkoutRepository;
        this.exerciseWorkoutService = exerciseWorkoutService;
    }

    @Transactional
    public Workout addExerciseToWorkout(Long workoutId, Long exerciseId) {
        WorkoutEntity referenceById = workoutRepository.getReferenceById(workoutId);
        ExerciseWorkoutEntity exerciseWorkoutById = exerciseWorkoutService.getExerciseWorkoutByIdEntity(exerciseId);
        referenceById.getExerciseWorkoutEntities().add(exerciseWorkoutById);
        return new Workout(referenceById);
    }


    public void createWorkoutData(Workout workout) {
        WorkoutEntity workoutEntity = new WorkoutEntity();
        workoutEntity.setDescription(workout.getDescription());
        workoutEntity.setTitle(workout.getTitle());
        workoutRepository.save(workoutEntity);
    }

    public Workout updateWorkout(Workout updatedWorkout) {
        WorkoutEntity referenceById = workoutRepository.getReferenceById(updatedWorkout.getId());
        referenceById.setDescription(updatedWorkout.getDescription());
        referenceById.setTitle(updatedWorkout.getTitle());
        WorkoutEntity workoutEntity = new WorkoutEntity(updatedWorkout);
        referenceById.setExerciseWorkoutEntities(workoutEntity.getExerciseWorkoutEntities());
        WorkoutEntity savedWorkoutEntity = workoutRepository.save(referenceById);
        return new Workout(savedWorkoutEntity);
    }


    public Workout getWorkoutById(Long id) {
        WorkoutEntity workoutEntity = workoutRepository.getReferenceById(id);
        return new Workout(workoutEntity);
    }


    public List<Workout> getALlWorkouts() {

        return workoutRepository.findAll()
                .stream()
                .map(Workout::new)
                .collect(Collectors.toList());
    }
}
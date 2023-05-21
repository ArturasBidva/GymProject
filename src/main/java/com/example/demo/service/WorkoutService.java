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

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WorkoutService {

    WorkoutRepository workoutRepository;
    ExerciseRepository exerciseRepository;
    ExerciseCategoryRepository exerciseCategoryRepository;

    ExerciseWorkoutRepository exerciseWorkoutRepository;

    WorkoutService(WorkoutRepository workoutRepository,
                   ExerciseRepository exerciseRepository,
                   ExerciseCategoryRepository exerciseCategoryRepository,
                   ExerciseWorkoutRepository exerciseWorkoutRepository) {
        this.workoutRepository = workoutRepository;
        this.exerciseRepository = exerciseRepository;
        this.exerciseCategoryRepository = exerciseCategoryRepository;
        this.exerciseWorkoutRepository = exerciseWorkoutRepository;
    }

    @Transactional
    public void createWorkoutData(Workout workout) {
        WorkoutEntity workoutEntity = new WorkoutEntity();
        workoutEntity.setDescription(workout.getDescription());
        workoutEntity.setTitle(workout.getTitle());
        workoutRepository.save(workoutEntity);
    }

    public void addExerciseToWorkout(Workout workout, Long exerciseWorkoutId) {
        WorkoutEntity referenceById = workoutRepository.getReferenceById(workout.getId());
        ExerciseWorkoutEntity exerciseWorkoutEntity = exerciseWorkoutRepository.getReferenceById(exerciseWorkoutId);
        List<ExerciseWorkoutEntity> exerciseWorkoutEntities = new ArrayList<>(referenceById.getExerciseWorkoutEntities());
        exerciseWorkoutEntities.add(exerciseWorkoutEntity);
        referenceById.setExerciseWorkoutEntities(exerciseWorkoutEntities);
        workoutRepository.save(referenceById);
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
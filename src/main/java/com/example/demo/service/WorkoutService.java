package com.example.demo.service;

import com.example.demo.Entities.WorkoutEntity;
import com.example.demo.Models.Exercise;
import com.example.demo.Models.ExerciseWorkout;
import com.example.demo.Models.Workout;
import com.example.demo.repository.ExerciseCategoryRepository;
import com.example.demo.repository.ExerciseRepository;
import com.example.demo.repository.ExerciseWorkoutRepository;
import com.example.demo.repository.WorkoutRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
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


    public void addExerciseWorkoutToWorkout(Long workoutId, ExerciseWorkout exerciseWorkout) {
        Workout workout = getWorkoutById(workoutId);
        workout.addToExerciseWorkouts(exerciseWorkout);
        updateWorkout(workout);
    }

    public void createWorkoutData(Workout workout) {
        WorkoutEntity workoutEntity = new WorkoutEntity();
        workoutEntity.setDescription(workout.getDescription());
        workoutEntity.setTitle(workout.getTitle());
        workoutRepository.save(workoutEntity);
    }

    @Transactional
    public void updateWorkout(Workout updatedWorkout) {
        WorkoutEntity referenceById = workoutRepository.getReferenceById(updatedWorkout.getId());
        referenceById.setDescription(updatedWorkout.getDescription());
        referenceById.setTitle(updatedWorkout.getTitle());
        WorkoutEntity workoutEntity = new WorkoutEntity(updatedWorkout);
        Set<Long> referenceExerciseIds = referenceById.getExerciseWorkoutEntities().stream()
                .map(exerciseWorkoutEntity -> exerciseWorkoutEntity.getExerciseEntity().getId())
                .collect(Collectors.toSet());

        Set<Long> updatedExerciseIds = workoutEntity.getExerciseWorkoutEntities().stream()
                .map(exerciseWorkout -> exerciseWorkout.getExerciseEntity().getId())
                .collect(Collectors.toSet());

        if(referenceExerciseIds.equals(updatedExerciseIds)){
            System.out.println("gotcha");
            return;
        }
        referenceById.setExerciseWorkoutEntities(workoutEntity.getExerciseWorkoutEntities());
        workoutRepository.save(referenceById);
    }

    public void deleteWorkoutById(Long workoutId) {
        WorkoutEntity referenceById = workoutRepository.getReferenceById(workoutId);
        workoutRepository.delete(referenceById);
    }

    public void addWorkoutToSchedule(Workout workout){
        WorkoutEntity referencedById = workoutRepository.getReferenceById(workout.getId());
        referencedById.setDate(workout.getDate());
        referencedById.setStartTime(workout.getStartTime());
        referencedById.setEndTime(workout.getEndTime());
        workoutRepository.save(referencedById);
    }

    public Workout getWorkoutById(Long id) {
        WorkoutEntity workoutEntity = workoutRepository.getReferenceById(id);
        return new Workout(workoutEntity);
    }

    public void deleteAllWorkouts() {
        workoutRepository.deleteAll();
    }


    public List<Workout> getALlWorkouts() {

        return workoutRepository.findAll()
                .stream()
                .map(Workout::new)
                .collect(Collectors.toList());
    }
}
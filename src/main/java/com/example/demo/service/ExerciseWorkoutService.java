package com.example.demo.service;

import com.example.demo.Entities.ExerciseEntity;
import com.example.demo.Entities.ExerciseWorkoutEntity;
import com.example.demo.Entities.WorkoutEntity;
import com.example.demo.Models.ExerciseWorkout;
import com.example.demo.Models.Workout;
import com.example.demo.repository.ExerciseCategoryRepository;
import com.example.demo.repository.ExerciseRepository;
import com.example.demo.repository.ExerciseWorkoutRepository;
import com.example.demo.repository.WorkoutRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ExerciseWorkoutService {
    ExerciseWorkoutRepository exerciseWorkoutRepository;
    ExerciseCategoryRepository exerciseCategoryRepository;
    ExerciseRepository exerciseRepository;
    WorkoutRepository workoutRepository;

    ExerciseWorkoutService(ExerciseWorkoutRepository exerciseWorkoutRepository,
                           ExerciseCategoryRepository exerciseCategoryRepository,
                           ExerciseRepository exerciseRepository,
                           WorkoutRepository workoutRepository
    ) {
        this.exerciseWorkoutRepository = exerciseWorkoutRepository;
        this.exerciseCategoryRepository = exerciseCategoryRepository;
        this.exerciseRepository = exerciseRepository;
        this.workoutRepository = workoutRepository;
    }

    public ExerciseWorkout createExerciseWorkout(ExerciseWorkout exerciseWorkout) {
        ExerciseWorkoutEntity exerciseWorkoutEntity = new ExerciseWorkoutEntity();
        exerciseWorkoutEntity.setGoal(exerciseWorkout.getGoal());
        ExerciseEntity exerciseEntityById = exerciseRepository.getReferenceById(exerciseWorkout.getExercise().getId());
        exerciseWorkoutEntity.setExerciseEntity(exerciseEntityById);
        return new ExerciseWorkout(exerciseWorkoutRepository.save(exerciseWorkoutEntity));
    }

    public void deleteExerciseWorkout(ExerciseWorkout exerciseWorkout) {
        ExerciseWorkoutEntity exerciseWorkoutEntity = exerciseWorkoutRepository.getReferenceById(exerciseWorkout.getId());

        exerciseWorkoutRepository.delete(exerciseWorkoutEntity);
    }

    @Transactional
    public void deleteExerciseWorkoutFromWorkout(Long workoutId, Long exerciseId) {
        WorkoutEntity referencedById = workoutRepository.getReferenceById(workoutId);
        List<ExerciseWorkoutEntity> collect = referencedById.getExerciseWorkoutEntities().stream().toList();
        Long getIdIfExist = collect.stream().filter(it -> it.getExerciseEntity().getId() == exerciseId).findFirst().orElse(null).getId();
        if (getIdIfExist != null) {
                ExerciseWorkoutEntity byId = exerciseWorkoutRepository.getReferenceById(getIdIfExist);
                referencedById.getExerciseWorkoutEntities().remove(byId);
                exerciseWorkoutRepository.delete(byId);
            }
        }


    public ExerciseWorkout getExerciseWorkoutById(Long id) {
        ExerciseWorkoutEntity exerciseWorkoutEntity = exerciseWorkoutRepository.getReferenceById(id);
        return new ExerciseWorkout(exerciseWorkoutEntity);
    }

    public ExerciseWorkout updateExerciseWorkout(ExerciseWorkout exerciseWorkout) {
        ExerciseWorkoutEntity exerciseWorkoutEntity = exerciseWorkoutRepository.getReferenceById(exerciseWorkout.getId());
        exerciseWorkoutEntity.setGoal(exerciseWorkout.getGoal());
        exerciseWorkoutEntity.setWeight(exerciseWorkout.getWeight());
        ExerciseWorkoutEntity updatedExerciseWorkout = exerciseWorkoutRepository.save(exerciseWorkoutEntity);
        return new ExerciseWorkout(updatedExerciseWorkout);
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

    public List<ExerciseWorkout> getExerciseWorkoutsByExerciseId(Long exerciseId) {
        return exerciseWorkoutRepository.findAll().stream().map(ExerciseWorkout::new).toList().stream().filter(it -> Objects.equals(it.getExercise().getId(), exerciseId)).collect(Collectors.toList());
    }
}

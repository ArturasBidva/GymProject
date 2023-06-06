package com.example.demo.repository;

import com.example.demo.Entities.ExerciseWorkoutEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseWorkoutRepository extends JpaRepository<ExerciseWorkoutEntity, Long> {
}

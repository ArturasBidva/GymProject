package com.example.demo.repository;

import com.example.demo.Entities.WorkoutEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkoutRepository extends JpaRepository<WorkoutEntity, Long> {

}

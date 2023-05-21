package com.example.demo.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "gym_workouts")
public class WorkoutEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String title;
    String description;
    @OneToMany(cascade = CascadeType.ALL)
    List<ExerciseWorkoutEntity> exerciseWorkoutEntities = new ArrayList<>();
}

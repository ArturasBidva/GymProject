package com.example.demo.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "gym_exercise_workout")
public class ExerciseWorkoutEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "workout_id")
    private WorkoutEntity workoutEntity;

    @ManyToOne
    @JoinColumn(name = "exercise_entity_id")
    private ExerciseEntity exerciseEntity;
    int completedCount = 0;
    int goal;

}

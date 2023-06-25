package com.example.demo.Models;

import com.example.demo.Entities.ExerciseWorkoutEntity;
import lombok.Data;

@Data
public class ExerciseWorkout {
    Long id;
    private Exercise exercise;
    int completedCount = 0;
    int goal;
    int weight = 0;

    public ExerciseWorkout() {

    }

    public ExerciseWorkout(ExerciseWorkoutEntity exerciseWorkoutEntity) {
        this.id = exerciseWorkoutEntity.getId();
        this.exercise = new Exercise(exerciseWorkoutEntity.getExerciseEntity());
        this.completedCount = exerciseWorkoutEntity.getCompletedCount();
        this.goal = exerciseWorkoutEntity.getGoal();
        this.weight = exerciseWorkoutEntity.getWeight();

    }
//
//    public List<Double> calculateWeightsPerSet(int goal,int weight) {
//        List<Double> weights = new ArrayList<>();
//        int warmupSets = goal / 4; // 25% of sets are for warming up
//        int workingSets = goal - warmupSets;
//
//        // Warm-up sets
//        for (int i = 0; i < warmupSets; i++) {
//            weights.add(weight * 0.5);
//        }
//
//        // Working sets
//        for (int i = 0; i < workingSets; i++) {
//            weights.add(weight * (0.6 + 0.2 * (i / (double)workingSets)));
//        }
//
//        return weights;
//    }
}

package com.example.demo.Entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "exercise", schema="public")
public class ExerciseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "exercise_generator")
  @SequenceGenerator(name = "exercise_generator", sequenceName = "exercise_seq", allocationSize = 1)
  private Long id;
  private String title;
  private int weight;

  public void setTitle(String title) {
    this.title = title;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }
}

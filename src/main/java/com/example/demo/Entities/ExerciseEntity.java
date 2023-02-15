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
  private String imgUrl;
  private String description;


  public void setTitle(String title) {
    this.title = title;
  }

  public void setImgUrl(String imgUrl) {
    this.imgUrl = imgUrl;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }
}


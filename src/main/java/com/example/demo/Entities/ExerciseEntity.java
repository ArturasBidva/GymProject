package com.example.demo.Entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "exercise")
public class ExerciseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
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


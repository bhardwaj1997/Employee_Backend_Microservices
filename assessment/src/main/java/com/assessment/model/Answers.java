package com.assessment.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Answers {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "AID")
  private int AnswerId;

  @Column(name = "firstAnswer")
  private String FirstAnswer;

  @Column(name = "secondAnswer")
  private String SecondAnswer;

  @Column(name = "thirdAnswer")
  private String ThirdAnswer;

  @Column(name = "fourthAnswer")
  private String FourthAnswer;

  @Column(name = "correctAnswer")
  private int CorrectAnswer;

  @ManyToOne
  private Questions questions;
}

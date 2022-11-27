package com.assessment.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class InterviewCriteria {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "SID")
  private int SelectionCriteriaId;
  @Column(name = "sectionA")
  private int SectionA;
  @Column(name = "sectionB")
  private int SectionB;
  @Column(name = "sectionC")
  private int SectionC;
  @Column(name = "sectionD")
  private int SectionD;
}

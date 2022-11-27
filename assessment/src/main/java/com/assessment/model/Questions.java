package com.assessment.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Questions {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "QId")
  private int QuestionId;
  @Column(name = "question")
  private String Question;
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "AID")
  private Answers Answer;
//  @OneToMany(mappedBy = "questions",cascade = CascadeType.ALL)
//  private List<Answers> ansId = new ArrayList<>();
  @ManyToMany(mappedBy = "questions",cascade = CascadeType.PERSIST)
  private List<Companies> CompanyId;
}

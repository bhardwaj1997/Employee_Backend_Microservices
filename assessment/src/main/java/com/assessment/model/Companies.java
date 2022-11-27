package com.assessment.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import jdk.nashorn.internal.ir.LiteralNode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Companies {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "CID")
  private int CompanyId;
  @Column(name = "companyName")
  private String CompanyName;
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "SID")
  private InterviewCriteria SelectionCriteriaId;
  @ManyToMany
  @JoinTable(name = "companyQuestion",joinColumns = {@JoinColumn(name = "CID")},inverseJoinColumns = {@JoinColumn(name = "QID")})
  private List<Questions> questions;
}

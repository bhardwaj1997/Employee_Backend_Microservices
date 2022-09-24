package com.employee.model;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "employee")
public class Employee {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID")
  private int id;

  @Column(name = "FirstName")
  private String firstName;

  @Column(name = "LastName")
  private String lastName;

  @Column(name = "DOB")
  private String dob;

  @Column(name = "emailid")
  private String emailId;

  @Column(name = "MobileNumber")
  private Integer mobileNo;

  @Column(name = "Gender")
  private Character gender;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "AddressId")
  private Address address;

  @Column(name = "password")
  private String password;
}

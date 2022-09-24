package com.employee;

import com.employee.service.EmployeeService;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
public class EmployeeApplication {

  @Autowired
  private EmployeeService employeeService;

  public static void main(String[] args) {
    SpringApplication.run(EmployeeApplication.class, args);
    System.out.println("Application Started");

  }
  @PostConstruct
  public void init(){
    System.out.println(" = " +employeeService.getAllEmailId("2022-09-04"));
  }
}

package com.employee.controller;

import com.employee.model.Employee;
import com.employee.service.EmployeeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

  @Autowired private EmployeeService employeeService;

  @GetMapping("/getEmployeeList")
  public ResponseEntity<List<Employee>> getAllEmployees() {
    return new ResponseEntity<List<Employee>>(employeeService.getEmployeeList(), HttpStatus.OK);
  }

  @PostMapping("/addEmployee")
  public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
    try {
      return new ResponseEntity<Employee>(
          employeeService.saveEmployee(employee), HttpStatus.CREATED);
    } catch (Exception e) {
      throw new RuntimeException(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR));
    }
  }
}

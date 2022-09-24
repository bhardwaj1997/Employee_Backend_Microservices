package com.employee.service;

import com.employee.model.Employee;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {
  public Employee saveEmployee(Employee employee);

  public List<Employee> getEmployeeList();

  Employee checkUser(String userId, String password);

  public List<Employee> getAllEmailId(String dob);
}

package com.employee.service.Impl;

import com.employee.dto.EmployeeListDto;
import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;
import com.employee.service.EmployeeService;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

  @Autowired private EmployeeRepository employeeRepository;

  @Override
  public Employee saveEmployee(Employee employee) {
    Employee status = employeeRepository.save(employee);
    return status;
  }

  @Override
  public List<Employee> getEmployeeList() {
    List<Employee> employeeList = employeeRepository.findAll();

    List<EmployeeListDto> employeeListDtoList =
        employeeList.stream()
            .map(e ->EmployeeListDto.builder()
                        .EmployeeId(e.getId())
                        .Name(e.getFirstName() + e.getLastName())
                        .EmailId(e.getEmailId())
                        .DOB(e.getDob())
                        .Address(e.getAddress())
                        .build())
            .collect(Collectors.toList());

    return  employeeRepository.findAll();
  }

  @Override
  public Employee checkUser(String userId, String password) {
    Optional<Employee> employee = employeeRepository.findByEmailId(userId);
    return null;
  }

  @Override
  public List<Employee> getAllEmailId(String dob) {
    LocalDate dateObj = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    String date = dateObj.format(formatter);
    System.out.println("date =:  " + date);
    return employeeRepository.findByDob(date.toString());
  }
}

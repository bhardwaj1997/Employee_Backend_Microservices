package com.employee.service.Impl;

import com.employee.dto.EmployeeListDto;
import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;
import com.employee.service.EmployeeService;
import java.util.List;
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

    return employeeRepository.findAll();
  }
}

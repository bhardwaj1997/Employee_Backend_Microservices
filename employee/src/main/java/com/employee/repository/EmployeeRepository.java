package com.employee.repository;

import com.employee.model.Employee;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

  Optional<Employee> findByEmailId(String userId);

  List<Employee> findByDob(String dob);
}

package com.example.week2.service;

import com.example.week2.entity.Employee;
import com.example.week2.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
  private final EmployeeRepository employeeRepository;
  public EmployeeService(EmployeeRepository employeeRepository) {
    this.employeeRepository = employeeRepository;
  }

  public List<Employee> getAllEmployees() {
    return employeeRepository.findAll();
  }


}

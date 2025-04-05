package com.example.week2.service.impl;

import com.example.week2.entity.Department;
import com.example.week2.entity.Employee;
import com.example.week2.repository.DepartmentRepository;
import com.example.week2.repository.EmployeeRepository;
import com.example.week2.service.EmployeeService;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
  private final EmployeeRepository employeeRepository;
  private final DepartmentRepository departmentRepository;

  public EmployeeServiceImpl(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
    this.employeeRepository = employeeRepository;
    this.departmentRepository = departmentRepository;
  }

  public List<Employee> findAll() {
    return employeeRepository.findAll();
  }

  public List<Employee> findByDepartment(Department department) {
  }
}

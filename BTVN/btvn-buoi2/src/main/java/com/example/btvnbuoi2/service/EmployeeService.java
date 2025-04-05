package com.example.btvnbuoi2.service;

import com.example.btvnbuoi2.model.Employee;
import com.example.btvnbuoi2.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeService {
  @Autowired
  private EmployeeRepository employeeRepository;

  public List<Employee> getAllEmployees() {
    return employeeRepository.findAll();
  }

  public Employee getEmployeeById(long id) {
    return employeeRepository.findById(id).orElse(null);
  }

  public Employee saveEmployee(Employee employee) {
    return employeeRepository.save(employee);
  }

  public Employee updateEmployee(Long id, Employee employeeDetails) {
    Employee employee = employeeRepository.findById(id).orElse(null);
    if (employee != null) {
      employee.setName(employeeDetails.getName());
      employee.setEmail(employeeDetails.getEmail());
      employee.setAddress(employeeDetails.getAddress());
      employee.setPhone(employeeDetails.getPhone());
      return employeeRepository.save(employee);
    }
    return null;
  }

  public void deleteEmployeeById(Long id) {
    employeeRepository.deleteById(id);
  }
}

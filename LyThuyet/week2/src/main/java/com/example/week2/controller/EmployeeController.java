package com.example.week2.controller;

import com.example.week2.entity.Employee;
import com.example.week2.service.EmployeeService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class EmployeeController {
  private EmployeeService employeeService;

  public EmployeeController(EmployeeService employeeService) {
    this.employeeService = employeeService;
  }

  @GetMapping("/employees")
  public String getEmployees(Model model) {
    List<Employee> employees = employeeService.getAllEmployees();
    model.addAttribute("employees", employees);
    return "employees";
  }
}

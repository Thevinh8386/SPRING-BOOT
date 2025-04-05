package com.example.week2.repository;

import com.example.week2.entity.Department;
import com.example.week2.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
  List<Employee> findAllByEmployees(List<Employee> employees);
}

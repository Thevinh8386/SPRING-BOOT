package com.example.btvnbuoi4.service;

import com.example.btvnbuoi4.dto.StudentDTO;
import com.example.btvnbuoi4.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
  List<Student> getAllStudents();
  Optional<Student> getStudentById(Integer id);
  public Student createStudent(Student student);
  public Student updateStudent(Student student);
  public void deleteStudent(Integer id);
}

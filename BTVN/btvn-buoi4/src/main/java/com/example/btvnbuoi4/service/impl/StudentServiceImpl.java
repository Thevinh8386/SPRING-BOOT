package com.example.btvnbuoi4.service.impl;

import com.example.btvnbuoi4.dto.StudentDTO;
import com.example.btvnbuoi4.model.Student;
import com.example.btvnbuoi4.repository.StudentRepository;
import com.example.btvnbuoi4.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
  @Autowired
  private StudentRepository studentRepository;

  @Override
  public List<Student> getAllStudents() {
    return studentRepository.findAll();
  }
  @Override
  public Optional<Student> getStudentById(Integer id) {
    return studentRepository.findById(id);
  }

  @Override
  public Student createStudent(Student student) {
    return studentRepository.save(student);
  }

  @Override
  public Student updateStudent(Student student) {
    return studentRepository.save(student);
  }

  @Override
  public void deleteStudent(Integer id) {
    studentRepository.deleteById(id);
  }
}

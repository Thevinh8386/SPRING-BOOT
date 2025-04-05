package com.example.btvnbuoi3.services.impl;

import com.example.btvnbuoi3.entities.Student;
import com.example.btvnbuoi3.repositories.StudentRepository;
import com.example.btvnbuoi3.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
  @Autowired
  private StudentRepository studentRepository;

  @Override
  public List<Student> findAll() {
    return studentRepository.findAll();
  }

  @Override
  public Optional<Student> findById(Long id) {
    return studentRepository.findById(id);
  }

  @Override
  public Student save(Student student) {
    return studentRepository.save(student);
  }

  @Override
  public void deleteById(Long id) {
    studentRepository.deleteById(id);
  }
}

package com.example.btvnbuoi3.services;

import com.example.btvnbuoi3.entities.Student;
import java.util.List;
import java.util.Optional;

public interface StudentService {
  List<Student> findAll();
  Optional<Student> findById(Long id);
  Student save(Student student);
  void deleteById(Long id);
}

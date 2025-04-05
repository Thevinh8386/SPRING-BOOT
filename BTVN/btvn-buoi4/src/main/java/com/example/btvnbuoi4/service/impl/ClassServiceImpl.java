package com.example.btvnbuoi4.service.impl;

import com.example.btvnbuoi4.model.SchoolClass;
import com.example.btvnbuoi4.repository.ClassRepository;
import com.example.btvnbuoi4.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassServiceImpl implements ClassService {
  @Autowired
  private ClassRepository classRepository;

  @Override
  public List<SchoolClass> getAllClasses() {
    return classRepository.findAll();
  }

  @Override
  public Optional<SchoolClass> getClassById(Integer id) {
    return classRepository.findById(id);
  }

  @Override
  public SchoolClass createClass(SchoolClass schoolClass) {
    return classRepository.save(schoolClass);
  }

  @Override
  public SchoolClass updateClass(SchoolClass schoolClass) {
    return classRepository.save(schoolClass);
  }

  @Override
  public void deleteClass(Integer id) {
    classRepository.deleteById(id);
  }
}

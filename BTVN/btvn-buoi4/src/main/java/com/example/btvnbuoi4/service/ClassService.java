package com.example.btvnbuoi4.service;

import com.example.btvnbuoi4.model.SchoolClass;

import java.util.List;
import java.util.Optional;

public interface ClassService {
  List<SchoolClass> getAllClasses();
  Optional<SchoolClass> getClassById(Integer id);
  SchoolClass createClass(SchoolClass schoolClass);
  SchoolClass updateClass(SchoolClass schoolClass);
  void deleteClass(Integer id);
}

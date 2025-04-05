package com.example.btvnbuoi4.controller;

import com.example.btvnbuoi4.dto.SchoolClassDTO;
import com.example.btvnbuoi4.exception.ResourceNotFoundException;
import com.example.btvnbuoi4.model.SchoolClass;
import com.example.btvnbuoi4.service.ClassService;
import com.example.btvnbuoi4.dto.mapping.EntityToDTOMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/classes")
public class ClassController {
  @Autowired
  private ClassService classService;

  // GET ALL CLASSES
  @GetMapping
  public ResponseEntity<List<SchoolClassDTO>> getAllClasses() {
    List<SchoolClass> classes = classService.getAllClasses();
    List<SchoolClassDTO> classDTOs = classes.stream()
        .map(EntityToDTOMapping::convertToSchoolClassDTO)
        .collect(Collectors.toList());
    return new ResponseEntity<>(classDTOs, HttpStatus.OK);
  }

  // GET CLASS BY ID
  @GetMapping("/{id}")
  public ResponseEntity<SchoolClassDTO> getClassById(@PathVariable Integer id) {
    Optional<SchoolClass> schoolClass = classService.getClassById(id);
    if (schoolClass.isPresent()) {
      return ResponseEntity.ok(EntityToDTOMapping.convertToSchoolClassDTO(schoolClass.get()));
    } else {
      throw new ResourceNotFoundException("Class not found with ID: " + id);
    }
  }

  // CREATE
  @PostMapping
  public ResponseEntity<SchoolClassDTO> createClass(@RequestBody SchoolClassDTO schoolClassDTO) {
    SchoolClass schoolClass = new SchoolClass();
    schoolClass.setName(schoolClassDTO.getName());
    schoolClass.setSubject(schoolClassDTO.getSubject());
    // SAVE
    SchoolClass createdClass = classService.createClass(schoolClass);
    return new ResponseEntity<>(EntityToDTOMapping.convertToSchoolClassDTO(createdClass), HttpStatus.CREATED);
  }

  // UPDATE
  @PutMapping("/{id}")
  public ResponseEntity<SchoolClassDTO> updateClass(@PathVariable Integer id, @RequestBody SchoolClassDTO schoolClassDTO) {
    Optional<SchoolClass> existingClass = classService.getClassById(id);
    if (existingClass.isPresent()) {
      SchoolClass schoolClass = existingClass.get();
      schoolClass.setName(schoolClassDTO.getName());
      schoolClass.setSubject(schoolClassDTO.getSubject());
      // UPDATE
      SchoolClass updatedClass = classService.updateClass(schoolClass);
      return new ResponseEntity<>(EntityToDTOMapping.convertToSchoolClassDTO(updatedClass), HttpStatus.OK);
    } else {
      throw new ResourceNotFoundException("Class not found with ID: " + id);
    }
  }

  // DELETE
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteClass(@PathVariable Integer id) {
    Optional<SchoolClass> existingClass = classService.getClassById(id);
    if (existingClass.isPresent()) {
      classService.deleteClass(id);
      return ResponseEntity.noContent().build();
    } else {
      throw new ResourceNotFoundException("Class not found with ID: " + id);
    }
  }
}
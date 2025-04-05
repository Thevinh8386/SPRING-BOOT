package com.example.btvnbuoi4.controller;

import com.example.btvnbuoi4.dto.StudentDTO;
import com.example.btvnbuoi4.exception.ResourceNotFoundException;
import com.example.btvnbuoi4.model.Student;
import com.example.btvnbuoi4.service.StudentService;
import com.example.btvnbuoi4.dto.mapping.EntityToDTOMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
  @Autowired
  private StudentService studentService;

  // GET ALL STUDENTS
  @GetMapping
  public ResponseEntity<List<StudentDTO>> getAllStudents() {
    List<Student> students = studentService.getAllStudents();
    List<StudentDTO> studentDTOs = students.stream()
        .map(EntityToDTOMapping::convertToStudentDTO)
        .collect(Collectors.toList());
    return new ResponseEntity<>(studentDTOs, HttpStatus.OK);
  }

  // GET STUDENT BY ID
  @GetMapping("/{id}")
  public ResponseEntity<StudentDTO> getStudentById(@PathVariable Integer id) {
    Optional<Student> student = studentService.getStudentById(id);
    if (student.isPresent()) {
      return ResponseEntity.ok(EntityToDTOMapping.convertToStudentDTO(student.get()));
    } else {
      throw new ResourceNotFoundException("Student not found with ID: " + id);
    }
  }

  // CREATE
  @PostMapping
  public ResponseEntity<StudentDTO> createStudent(@RequestBody StudentDTO studentDTO) {
    // CONVERT DTO TO ENTITY
    Student student = new Student();
    student.setName(studentDTO.getName());
    student.setDob(studentDTO.getDob());
    student.setGender(studentDTO.getGender());
    student.setEmail(studentDTO.getEmail());
    student.setPhone(studentDTO.getPhone());
    // SAVE
    Student createdStudent = studentService.createStudent(student);
    return new ResponseEntity<>(EntityToDTOMapping.convertToStudentDTO(createdStudent), HttpStatus.CREATED);
  }

  // UPDATE
  @PutMapping("/{id}")
  public ResponseEntity<StudentDTO> updateStudent(@PathVariable Integer id, @RequestBody StudentDTO studentDTO) {
    Optional<Student> existingStudent = studentService.getStudentById(id);
    if (existingStudent.isPresent()) {
      Student student = existingStudent.get();
      student.setName(studentDTO.getName());
      student.setDob(studentDTO.getDob());
      student.setGender(studentDTO.getGender());
      student.setEmail(studentDTO.getEmail());
      student.setPhone(studentDTO.getPhone());
      // UPDATE
      Student updatedStudent = studentService.updateStudent(student);
      return new ResponseEntity<>(EntityToDTOMapping.convertToStudentDTO(updatedStudent), HttpStatus.OK);
    } else {
      throw new ResourceNotFoundException("Student not found with ID: " + id);
    }
  }

  // DELETE
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteStudent(@PathVariable Integer id) {
    Optional<Student> existingStudent = studentService.getStudentById(id);
    if (existingStudent.isPresent()) {
      studentService.deleteStudent(id);
      return ResponseEntity.noContent().build();
    } else {
      throw new ResourceNotFoundException("Student not found with ID: " + id);
    }
  }
}
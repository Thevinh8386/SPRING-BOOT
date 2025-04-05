package com.example.btvnbuoi4.dto.mapping;

import com.example.btvnbuoi4.dto.SchoolClassDTO;
import com.example.btvnbuoi4.dto.StudentClassDTO;
import com.example.btvnbuoi4.dto.StudentDTO;
import com.example.btvnbuoi4.model.SchoolClass;
import com.example.btvnbuoi4.model.Student;
import java.util.List;
import java.util.stream.Collectors;

public class EntityToDTOMapping {
  public static StudentDTO convertToStudentDTO(Student student) {
    if (student == null) return null;

    StudentDTO studentDTO = new StudentDTO();
    studentDTO.setId(student.getId());
    studentDTO.setName(student.getName());
    studentDTO.setDob(student.getDob());
    studentDTO.setGender(student.getGender());
    studentDTO.setEmail(student.getEmail());
    studentDTO.setPhone(student.getPhone());

    if (student.getClasses() != null) {
      studentDTO.setClasses(student.getClasses().stream()
          .map(EntityToDTOMapping::convertToSchoolClassDTO)
          .collect(Collectors.toList()));
    }
    return studentDTO;
  }

  public static SchoolClassDTO convertToSchoolClassDTO(SchoolClass clazz) {
    if (clazz == null) return null;

    SchoolClassDTO dto = new SchoolClassDTO();
    dto.setId(clazz.getId());
    dto.setName(clazz.getName());
    dto.setSubject(clazz.getSubject());

    if (clazz.getStudents() != null) {
      List<StudentClassDTO> studentClassDTO = clazz.getStudents()
          .stream()
          .map(EntityToDTOMapping::convertToStudentClassDTO)
          .collect(Collectors.toList());
      dto.setStudents(studentClassDTO);
    }
    return dto;
  }

  public static StudentClassDTO convertToStudentClassDTO(Student student) {
    if (student == null) return null;
    StudentClassDTO studentClassDTO = new StudentClassDTO();
    studentClassDTO.setId(student.getId());
    studentClassDTO.setName(student.getName());
    return studentClassDTO;
  }
}

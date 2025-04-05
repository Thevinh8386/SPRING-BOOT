package com.example.btvnbuoi3.controllers;

import com.example.btvnbuoi3.entities.Student;
import com.example.btvnbuoi3.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;


@Controller
@RequestMapping("/students/")
public class StudentController {
  @Autowired
  private StudentService studentService;

  @GetMapping("")
  public String listStudents(Model model) {
    model.addAttribute("students", studentService.findAll());
    return "list";
  }

  @GetMapping("/add")
  public String createStudentForm(Model model) {
    model.addAttribute("student", new Student());
    return "students/add";
  }

  @PostMapping
  public String saveStudent(@ModelAttribute Student student) {
    studentService.save(student);
    return "redirect:/students";
  }

  @GetMapping("/edit/{id}")
  public String editStudentForm(@PathVariable Long id, Model model) {
    Optional<Student> student = studentService.findById(id);
    if (student.isPresent()) {
      model.addAttribute("student", student.get());
      return "students/edit";
    }
    return "redirect:/students/edit";
  }

  @PostMapping("/update/{id}")
  public String updateStudent(@PathVariable Long id, @ModelAttribute Student student) {
    student.setId(id);
    studentService.save(student);
    return "redirect:/students/update";
  }

  @GetMapping("/delete/{id}")
  public String deleteStudent(@PathVariable Long id) {
    studentService.deleteById(id);
    return "redirect:/students/delete";
  }
}

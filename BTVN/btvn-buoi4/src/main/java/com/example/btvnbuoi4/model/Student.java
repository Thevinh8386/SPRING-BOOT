package com.example.btvnbuoi4.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "students")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "name", nullable = false, length = 150)
  private String name;

  @Column(name = "dob")
  private Date dob;

  @Column(name = "gender")
  private Gender gender;

  @Column(name = "email", unique = true, length = 250)
  private String email;

  @Column(name = "phone", length = 12)
  private String phone;

  @ManyToMany
  @JoinTable(
      name = "student_class",
      joinColumns = @JoinColumn(name = "student_id"),
      inverseJoinColumns = @JoinColumn(name = "class_id")
  )
  private List<SchoolClass> classes = new ArrayList<SchoolClass>();
}

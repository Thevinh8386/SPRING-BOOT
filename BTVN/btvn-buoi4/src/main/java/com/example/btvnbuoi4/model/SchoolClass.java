package com.example.btvnbuoi4.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "classes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class SchoolClass {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @NotNull(message = "Không được để trống tên lớp")
  @Column(name = "name", nullable = false, length = 50)
  private String name;

  @NotNull(message = "Không được để trống môn học")
  @Column(name = "subject")
  private String subject;

  @ManyToMany(mappedBy = "classes")
  private List<Student> students = new ArrayList<Student>();
}
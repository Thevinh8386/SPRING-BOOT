package com.example.btvnbuoi4.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class SchoolClassDTO implements Serializable {
  private int id;
  private String name;
  private String subject;
  private List<StudentClassDTO> students;
}

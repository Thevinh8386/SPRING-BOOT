package com.example.btvnbuoi4.dto;

import com.example.btvnbuoi4.model.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO implements Serializable {
  private int id;
  private String name;
  private Date dob;
  private Gender gender;
  private String email;
  private String phone;
  private List<SchoolClassDTO> classes;
}

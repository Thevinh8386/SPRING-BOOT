package com.example.btvnbuoi3.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "students")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(name = "full_name", nullable = false, length = 100)
  private String name;

  @Column(name = "email", unique = true, length = 150)
  private String email;

  @Column(name = "phone_number", length = 15)
  private String phone;

  @Column(name = "home_address", columnDefinition = "TEXT")
  private String address;

  //Getters
  public long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public String getPhone() {
    return phone;
  }

  public String getAddress() {
    return address;
  }

  //Setters
  public void setId(long id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public void setAddress(String address) {
    this.address = address;
  }
}

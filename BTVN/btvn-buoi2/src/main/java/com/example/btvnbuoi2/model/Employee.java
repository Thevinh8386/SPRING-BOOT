package com.example.btvnbuoi2.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "NHAN_VIEN")
public class Employee {
  @Id
  @Column(name = "id", length = 20)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "name", length = 50)
  private String name;
  @Column(name = "email", length = 80)
  private String email;
  @Column(name = "address", length = 100)
  private String address;
  @Column(name = "phone", length = 12)
  private String phone;

  public Employee(String name, String address, String email, String phone) {
    this.name = name;
    this.email = email;
    this.address = address;
    this.phone = phone;
  }
}

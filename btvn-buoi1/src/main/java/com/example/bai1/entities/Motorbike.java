package com.example.bai1.entities;

import com.example.bai1.interfaces.Vehicle;
import org.springframework.stereotype.Component;

@Component("motorbike")
public class Motorbike implements Vehicle {
  @Override
  public void move() {
    System.out.println("Motorbike is moving...");
  }
}
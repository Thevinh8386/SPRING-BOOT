package com.example.bai1.entities;

import com.example.bai1.interfaces.Vehicle;
import org.springframework.stereotype.Component;

@Component("car")
public class Car implements Vehicle {
  @Override
  public void move() {
    System.out.println("Car is moving.");
  }
}

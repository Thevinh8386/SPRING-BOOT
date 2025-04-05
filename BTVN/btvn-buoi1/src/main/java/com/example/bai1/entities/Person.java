package com.example.bai1.entities;

import com.example.bai1.interfaces.Engine;
import com.example.bai1.interfaces.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Person {
  private final Vehicle vehicle;
  private final Engine engine;

  @Autowired
  public Person(@Qualifier("car") Vehicle vehicle, @Qualifier("gasolineEngine") Engine engine) {
    this.vehicle = vehicle;
    this.engine = engine;
  }

  public void useVehicle() {
    engine.start();
    vehicle.move();
  }
}

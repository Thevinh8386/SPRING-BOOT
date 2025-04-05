package com.example.bai1.impl;


import com.example.bai1.interfaces.Engine;
import org.springframework.stereotype.Component;

@Component("electricEngine")
public class ElectricEngine implements Engine {
  @Override
  public void start() {
    System.out.println("Electric engine is starting.");
  }
}
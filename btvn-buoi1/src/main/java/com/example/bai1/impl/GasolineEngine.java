package com.example.bai1.impl;

import com.example.bai1.interfaces.Engine;
import org.springframework.stereotype.Component;

@Component("gasolineEngine")
public class GasolineEngine implements Engine {
    @Override
    public void start() {
        System.out.println("Gasoline engine is starting.");
    }
}
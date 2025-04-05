package com.example.hit_spring_boot;

import org.springframework.stereotype.Component;

@Component
public class Samsung implements Phone{
    @Override
    public void call() {
        System.out.println("Call by Samsung!");
    }
}

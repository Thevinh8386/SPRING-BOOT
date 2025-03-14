package com.example.bai2.impl;

import com.example.bai2.interfaces.Order;
import org.springframework.stereotype.Component;

@Component("fastFoodOrder")
public class FastFoodOrder implements Order {
    @Override
    public void placeOrder() {
      System.out.println("Đặt món ăn nhanh...");
    }
}

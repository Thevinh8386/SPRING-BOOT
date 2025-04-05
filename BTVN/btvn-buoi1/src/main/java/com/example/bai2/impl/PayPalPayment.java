package com.example.bai2.impl;

import com.example.bai2.interfaces.PaymentMethod;
import org.springframework.stereotype.Component;

@Component("paypalPayment")
public class PayPalPayment implements PaymentMethod {
  @Override
  public void pay() {
    System.out.println("Thanh toán qua PayPal...");
  }
}

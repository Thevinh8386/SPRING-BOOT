package com.example.bai2.impl;

import com.example.bai2.interfaces.PaymentMethod;
import org.springframework.stereotype.Component;

@Component("creditCard")
public class CreditCardPayment implements PaymentMethod {
  @Override
  public void pay() {
    System.out.println("Thanh toán bằng thẻ tín dụng...");
  }
}

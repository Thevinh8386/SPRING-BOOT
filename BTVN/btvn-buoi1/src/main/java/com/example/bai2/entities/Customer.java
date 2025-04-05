package com.example.bai2.entities;

import com.example.bai2.interfaces.Order;
import com.example.bai2.interfaces.PaymentMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Customer {
  private Order order;
  private PaymentMethod paymentMethod;

  @Autowired
  public Customer(@Qualifier("fastFoodOrder") Order order,@Qualifier("paypalPayment") PaymentMethod paymentMethod) {
    this.order = order;
    this.paymentMethod = paymentMethod;
  }

  public void run() {
    order.placeOrder();
    paymentMethod.pay();
  }
}


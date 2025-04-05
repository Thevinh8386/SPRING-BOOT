package com.example.bai2;

import com.example.bai2.entities.Customer;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class BtvnBuoi1Application {
  public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext("com.example.bai2");
    Customer customer = (Customer) context.getBean("customer");
    customer.run();
  }
}

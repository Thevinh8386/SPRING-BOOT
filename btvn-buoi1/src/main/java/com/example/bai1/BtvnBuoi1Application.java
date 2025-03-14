package com.example.bai1;

import com.example.bai1.entities.Person;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class BtvnBuoi1Application {
  public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext("com.example.bai1");
    Person person = (Person) context.getBean("person");
    person.useVehicle();
  }
}

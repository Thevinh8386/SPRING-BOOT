package com.example.hit_spring_boot;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


@SpringBootApplication
public class HitSpringBootApplication {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext("com.example");
		User user = context.getBean(User.class);
		user.makeCall();
	}

}

package com.example.hit_spring_boot;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class User {
    private final Phone phone;

    public User(@Qualifier("samsung") Phone phone) {
        this.phone = phone;
    }

    public void makeCall() {
        phone.call();
    }
}

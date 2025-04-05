package com.example.week4.services.impl;

import com.example.week4.models.User;
import com.example.week4.repository.UserRepository;
import com.example.week4.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
  //C1
  @Autowired
  UserRepository userRepository;
  //C2
  // private final UserRepository userRepository; => @RequiredArgsConstructor

  @Override
  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  @Override
  public User getUserById(long id) {
    return userRepository.getById(id);
  }

  @Override
  public User createUser(User user) {
    userRepository.save(user);
    return user;
  }

  @Override
  public void updateUser(User user) {
    userRepository.save(user);
  }

  @Override
  public void deleteUserById(long id) {
    userRepository.deleteById(id);
  }
}

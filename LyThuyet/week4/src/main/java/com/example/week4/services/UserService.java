package com.example.week4.services;

import com.example.week4.models.User;

import java.util.List;

public interface UserService {
  List<User> getAllUsers();
  public User getUserById(long id);
  User createUser(User user);
  void updateUser(User user);
  void deleteUserById(long id);
}

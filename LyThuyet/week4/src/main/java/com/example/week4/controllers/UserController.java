package com.example.week4.controllers;

import com.example.week4.models.User;
import com.example.week4.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
  private final UserService userService;

  @GetMapping("/getAllUsers")
  public List<User> getAllUsers() {
    return userService.getAllUsers();
  }

  @GetMapping("/getUserById/{id}")
  public User getUserById(long id) {
    return userService.getUserById(id);
  }

  @PostMapping("/creat")
  public ResponseEntity<User> createUser(@RequestBody User user) {
    User createdUser = userService.createUser(user);
    return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
  }

  @PutMapping("/update/{id}")
  public void updateUser(@RequestBody User user, @PathVariable Long id) {
    user.setId(id);
    userService.updateUser(user);
  }

  @DeleteMapping("/delete/{id}")
  public void deleteUserById(@PathVariable long id) {
    userService.deleteUserById(id);
  }
}

package com.example.ai_generated_shop.service;

import com.example.ai_generated_shop.entity.User;
import com.example.ai_generated_shop.repository.UserRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private final UserRepository userRepository;

  @Autowired
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public void registerUser(String username, String password) {
    Optional<User> existingUser = userRepository.findByUsername(username);
    if (existingUser.isPresent()) {
      System.out.println("Username already exists.");
    } else {
      User user = new User();
      user.setUsername(username);
      user.setPassword(password); // Необходимо хешировать пароль перед сохранением в реальном приложении
      userRepository.save(user);
      System.out.println("User registered successfully.");
    }
  }

  public boolean authenticateUser(String username, String password) {
    Optional<User> optionalUser = userRepository.findByUsername(username);
    return optionalUser.map(user -> user.getPassword().equals(password)).orElse(false);
  }

  public Optional<User> getUserByUsername(String username) {
    return userRepository.findByUsername(username);
  }

  public User findById(Long id) {
    return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
  }
}

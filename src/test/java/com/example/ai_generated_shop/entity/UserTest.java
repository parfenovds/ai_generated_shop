package com.example.ai_generated_shop.entity;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserTest {

  @Test
  public void testUserCreationAndGetters() {
    // Create a user
    Long id = 1L;
    String username = "testuser";
    String password = "testpassword";

    User user = new User(id, username, password);

    // Check the values using getters
    assertThat(user.getId()).isEqualTo(id);
    assertThat(user.getUsername()).isEqualTo(username);
    assertThat(user.getPassword()).isEqualTo(password);
  }

  @Test
  public void testEqualsAndHashCode() {
    User user1 = new User(1L, "user1", "password1");
    User user2 = new User(1L, "user1", "password1");

    assertThat(user1).isEqualTo(user2);
    assertThat(user1.hashCode()).isEqualTo(user2.hashCode());
  }

  // Add more tests as needed
}
package com.example.ai_generated_shop.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class UserDTOTest {

  @Test
  public void testUserDTOFields() {
    // Arrange
    Long id = 1L;
    String username = "JohnDoe";

    // Act
    UserDTO userDTO = UserDTO.builder()
        .id(id)
        .username(username)
        .build();

    // Assert
    assertThat(userDTO.getId()).isEqualTo(id);
    assertThat(userDTO.getUsername()).isEqualTo(username);
  }

  @Test
  public void testUserDTOToString() {
    // Arrange
    Long id = 1L;
    String username = "JohnDoe";

    // Act
    UserDTO userDTO = UserDTO.builder()
        .id(id)
        .username(username)
        .build();

    // Assert
    assertThat(userDTO.toString()).contains("UserDTO");
  }
}
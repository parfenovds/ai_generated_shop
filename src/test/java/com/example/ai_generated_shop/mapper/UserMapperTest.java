package com.example.ai_generated_shop.mapper;

import com.example.ai_generated_shop.dto.UserDTO;
import com.example.ai_generated_shop.entity.User;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserMapperTest {

  private final UserMapper userMapper = UserMapper.INSTANCE;

  @Test
  public void testToUser() {
    UserDTO userDTO = new UserDTO();
    userDTO.setUsername("JohnDoe");

    User user = userMapper.toUser(userDTO);

    assertNotNull(user);
    assertEquals(userDTO.getUsername(), user.getUsername());
  }

  @Test
  public void testToUserDTO() {
    User user = new User();
    user.setUsername("JohnDoe");

    UserDTO userDTO = userMapper.toUserDTO(user);

    assertNotNull(userDTO);
    assertEquals(user.getUsername(), userDTO.getUsername());
  }
}
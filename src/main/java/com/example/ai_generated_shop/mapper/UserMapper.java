package com.example.ai_generated_shop.mapper;

import com.example.ai_generated_shop.dto.UserDTO;
import com.example.ai_generated_shop.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

  UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

  @Mapping(target = "id", ignore = true) // Игнорируем id, так как он генерируется автоматически
  User toUser(UserDTO userDTO);

  UserDTO toUserDTO(User user);
}
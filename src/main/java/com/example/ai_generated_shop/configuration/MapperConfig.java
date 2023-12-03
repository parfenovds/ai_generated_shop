package com.example.ai_generated_shop.configuration;

import com.example.ai_generated_shop.mapper.CartItemMapper;
import com.example.ai_generated_shop.mapper.CartMapper;
import com.example.ai_generated_shop.mapper.OrderItemMapper;
import com.example.ai_generated_shop.mapper.OrderMapper;
import com.example.ai_generated_shop.mapper.ProductMapper;
import com.example.ai_generated_shop.mapper.UserMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

  @Bean
  public CartMapper cartMapper() {
    return Mappers.getMapper(CartMapper.class);
  }

  @Bean
  public ProductMapper productMapper() {
    return Mappers.getMapper(ProductMapper.class);
  }
  @Bean
  public CartItemMapper cartItemMapper() {
    return Mappers.getMapper(CartItemMapper.class);
  }
  @Bean
  public UserMapper userMapper() {
    return Mappers.getMapper(UserMapper.class);
  }
  @Bean
  public OrderMapper orderMapper() {
    return Mappers.getMapper(OrderMapper.class);
  }
  @Bean
  public OrderItemMapper orderItemMapper() {
    return Mappers.getMapper(OrderItemMapper.class);
  }
}
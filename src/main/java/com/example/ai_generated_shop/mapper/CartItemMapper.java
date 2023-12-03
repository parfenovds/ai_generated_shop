package com.example.ai_generated_shop.mapper;

import com.example.ai_generated_shop.dto.CartItemDTO;
import com.example.ai_generated_shop.entity.CartItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper
public interface CartItemMapper {

  CartItemMapper INSTANCE = Mappers.getMapper(CartItemMapper.class);

  @Mapping(source = "product.id", target = "productId")
  CartItemDTO cartItemToCartItemDTO(CartItem cartItem);
}

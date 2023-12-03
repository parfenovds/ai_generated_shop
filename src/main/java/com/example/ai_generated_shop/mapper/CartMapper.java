package com.example.ai_generated_shop.mapper;

import com.example.ai_generated_shop.dto.CartDTO;
import com.example.ai_generated_shop.dto.CartItemDTO;
import com.example.ai_generated_shop.entity.Cart;
import com.example.ai_generated_shop.entity.CartItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import java.util.Set;
import org.springframework.stereotype.Component;

@Mapper(uses = {CartItemMapper.class, UserMapper.class})
public interface CartMapper {

  CartMapper INSTANCE = Mappers.getMapper(CartMapper.class);

  @Mapping(target = "cartItems", source = "cartItems")
  @Mapping(source = "user.id", target = "userId")
  CartDTO cartToCartDTO(Cart cart);

  Set<CartItemDTO> cartItemsToCartItemDTOs(Set<CartItem> cartItems);
}
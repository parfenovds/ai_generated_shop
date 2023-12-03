package com.example.ai_generated_shop.mapper;

import com.example.ai_generated_shop.dto.CartItemDTO;
import com.example.ai_generated_shop.entity.CartItem;
import com.example.ai_generated_shop.entity.Product;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CartItemMapperTest {

  private final CartItemMapper mapper = CartItemMapper.INSTANCE;

  @Test
  public void testCartItemToCartItemDTO() {
    // Create a CartItem
    CartItem cartItem = new CartItem();
    cartItem.setId(1L);

    Product product = new Product();
    product.setId(100L);

    cartItem.setProduct(product);
    cartItem.setQuantity(5);
    cartItem.setPrice(20.0);

    // Map CartItem to CartItemDTO
    CartItemDTO cartItemDTO = mapper.cartItemToCartItemDTO(cartItem);

    // Validate the mapping
    assertEquals(cartItem.getId(), cartItemDTO.getId());
    assertEquals(cartItem.getProduct().getId(), cartItemDTO.getProductId());
    assertEquals(cartItem.getQuantity(), cartItemDTO.getQuantity());
    assertEquals(cartItem.getPrice(), cartItemDTO.getPrice());
  }
}
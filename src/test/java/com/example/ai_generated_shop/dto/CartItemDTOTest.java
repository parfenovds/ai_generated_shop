package com.example.ai_generated_shop.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class CartItemDTOTest {

  @Test
  public void testCartItemDTOFields() {
    // Arrange
    Long id = 1L;
    Long productId = 10L;
    int quantity = 5;
    double price = 25.0;

    // Act
    CartItemDTO cartItemDTO = CartItemDTO.builder()
        .id(id)
        .productId(productId)
        .quantity(quantity)
        .price(price)
        .build();

    // Assert
    assertThat(cartItemDTO.getId()).isEqualTo(id);
    assertThat(cartItemDTO.getProductId()).isEqualTo(productId);
    assertThat(cartItemDTO.getQuantity()).isEqualTo(quantity);
    assertThat(cartItemDTO.getPrice()).isEqualTo(price);
  }

  @Test
  public void testCartItemDTOToString() {
    // Arrange
    Long id = 1L;
    Long productId = 10L;
    int quantity = 5;
    double price = 25.0;

    // Act
    CartItemDTO cartItemDTO = CartItemDTO.builder()
        .id(id)
        .productId(productId)
        .quantity(quantity)
        .price(price)
        .build();

    // Assert
    assertThat(cartItemDTO.toString()).contains("CartItemDTO");
  }
}

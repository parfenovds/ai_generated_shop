package com.example.ai_generated_shop.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class OrderItemDTOTest {

  @Test
  public void testOrderItemDTOFields() {
    // Arrange
    Long id = 1L;
    Long productId = 10L;
    int quantity = 5;
    double price = 50.0;

    // Act
    OrderItemDTO orderItemDTO = OrderItemDTO.builder()
        .id(id)
        .productId(productId)
        .quantity(quantity)
        .price(price)
        .build();

    // Assert
    assertThat(orderItemDTO.getId()).isEqualTo(id);
    assertThat(orderItemDTO.getProductId()).isEqualTo(productId);
    assertThat(orderItemDTO.getQuantity()).isEqualTo(quantity);
    assertThat(orderItemDTO.getPrice()).isEqualTo(price);
  }

  @Test
  public void testOrderItemDTOToString() {
    // Arrange
    Long id = 1L;
    Long productId = 10L;
    int quantity = 5;
    double price = 50.0;

    // Act
    OrderItemDTO orderItemDTO = OrderItemDTO.builder()
        .id(id)
        .productId(productId)
        .quantity(quantity)
        .price(price)
        .build();

    // Assert
    assertThat(orderItemDTO.toString()).contains("OrderItemDTO");
  }
}
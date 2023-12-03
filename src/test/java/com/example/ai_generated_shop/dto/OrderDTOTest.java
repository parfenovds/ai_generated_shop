package com.example.ai_generated_shop.dto;

import com.example.ai_generated_shop.enumeration.OrderStatus;
import org.junit.jupiter.api.Test;
import java.util.HashSet;
import java.util.Set;
import static org.assertj.core.api.Assertions.assertThat;

public class OrderDTOTest {

  @Test
  public void testOrderDTOFields() {
    // Arrange
    Long id = 1L;
    Long userId = 10L;
    double totalAmount = 100.0;
    OrderStatus status = OrderStatus.CREATED;
    Set<OrderItemDTO> items = new HashSet<>();

    // Act
    OrderDTO orderDTO = OrderDTO.builder()
        .id(id)
        .userId(userId)
        .totalAmount(totalAmount)
        .status(status)
        .items(items)
        .build();

    // Assert
    assertThat(orderDTO.getId()).isEqualTo(id);
    assertThat(orderDTO.getUserId()).isEqualTo(userId);
    assertThat(orderDTO.getTotalAmount()).isEqualTo(totalAmount);
    assertThat(orderDTO.getStatus()).isEqualTo(status);
    assertThat(orderDTO.getItems()).isEqualTo(items);
  }

  @Test
  public void testOrderDTOToString() {
    // Arrange
    Long id = 1L;
    Long userId = 10L;
    double totalAmount = 100.0;
    OrderStatus status = OrderStatus.CREATED;
    Set<OrderItemDTO> items = new HashSet<>();

    // Act
    OrderDTO orderDTO = OrderDTO.builder()
        .id(id)
        .userId(userId)
        .totalAmount(totalAmount)
        .status(status)
        .items(items)
        .build();

    // Assert
    assertThat(orderDTO.toString()).contains("OrderDTO");
  }
}

package com.example.ai_generated_shop.mapper;

import com.example.ai_generated_shop.dto.OrderItemDTO;
import com.example.ai_generated_shop.entity.OrderItem;
import com.example.ai_generated_shop.entity.Product;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class OrderItemMapperTest {

  private final OrderItemMapper orderItemMapper = OrderItemMapper.INSTANCE;

  @Test
  public void testToOrderItemDTO() {
    // Create an OrderItem
    OrderItem orderItem = new OrderItem();
    orderItem.setId(1L);

    Product product = new Product();
    product.setId(100L);

    orderItem.setProduct(product);
    orderItem.setQuantity(5);
    orderItem.setPrice(20.0);

    // Map OrderItem to OrderItemDTO
    OrderItemDTO orderItemDTO = orderItemMapper.toOrderItemDTO(orderItem);

    // Validate the mapping
    assertNotNull(orderItemDTO);
    assertEquals(orderItem.getId(), orderItemDTO.getId());
    assertEquals(orderItem.getProduct().getId(), orderItemDTO.getProductId());
    assertEquals(orderItem.getQuantity(), orderItemDTO.getQuantity());
    assertEquals(orderItem.getPrice(), orderItemDTO.getPrice());
  }
}

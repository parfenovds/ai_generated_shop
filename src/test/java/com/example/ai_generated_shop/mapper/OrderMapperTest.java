package com.example.ai_generated_shop.mapper;

import com.example.ai_generated_shop.dto.OrderDTO;
import com.example.ai_generated_shop.entity.Order;
import com.example.ai_generated_shop.entity.OrderItem;
import com.example.ai_generated_shop.entity.User;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class OrderMapperTest {

  private final OrderMapper orderMapper = OrderMapper.INSTANCE;

  @Test
  public void testToOrderDTO() {
    // Create an Order
    Order order = new Order();
    order.setId(1L);
    order.setTotalAmount(100.0);

    User user = new User();
    user.setId(10L);

    order.setUser(user);

    OrderItem orderItem = new OrderItem();
    orderItem.setId(5L);

    Set<OrderItem> orderItems = new HashSet<>();
    orderItems.add(orderItem);

    order.setItems(orderItems);

    // Map Order to OrderDTO
    OrderDTO orderDTO = orderMapper.toOrderDTO(order);

    // Validate the mapping
    assertNotNull(orderDTO);
    assertEquals(order.getId(), orderDTO.getId());
    assertEquals(order.getTotalAmount(), orderDTO.getTotalAmount());
    assertEquals(order.getUser().getId(), orderDTO.getUserId());
    // Validate other mappings as needed
  }
}
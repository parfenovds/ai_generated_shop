package com.example.ai_generated_shop.entity;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OrderItemTest {

  @Mock
  private Product product;

  @Mock
  private Order order;

  @InjectMocks
  private OrderItem orderItem;

  @Test
  public void testGettersAndSetters() {
    // Set up
    Long id = 1L;
    int quantity = 5;
    double price = 10.0;

    orderItem.setId(id);
    orderItem.setProduct(product);
    orderItem.setQuantity(quantity);
    orderItem.setPrice(price);
    orderItem.setOrder(order);

    // Verify
    assertEquals(id, orderItem.getId());
    assertEquals(product, orderItem.getProduct());
    assertEquals(quantity, orderItem.getQuantity());
    assertEquals(price, orderItem.getPrice());
    assertEquals(order, orderItem.getOrder());
  }

  // Add more test cases as needed
}
package com.example.ai_generated_shop.entity;

import com.example.ai_generated_shop.enumeration.OrderStatus;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OrderTest {

  @Mock
  private User user;

  @Mock
  private OrderItem orderItem1;

  @Mock
  private OrderItem orderItem2;

  @InjectMocks
  private Order order;

  @Test
  public void testGettersAndSetters() {
    // Set up
    Long id = 1L;
    double totalAmount = 100.0;
    OrderStatus status = OrderStatus.CREATED;
    Set<OrderItem> items = new HashSet<>();
    items.add(orderItem1);
    items.add(orderItem2);

    order.setId(id);
    order.setUser(user);
    order.setTotalAmount(totalAmount);
    order.setStatus(status);
    order.setItems(items);

    // Verify
    assertEquals(id, order.getId());
    assertEquals(user, order.getUser());
    assertEquals(totalAmount, order.getTotalAmount());
    assertEquals(status, order.getStatus());
    assertEquals(items, order.getItems());
  }

  // Add more test cases as needed
}

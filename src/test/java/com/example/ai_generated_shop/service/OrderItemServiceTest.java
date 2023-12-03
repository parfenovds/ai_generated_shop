package com.example.ai_generated_shop.service;

import com.example.ai_generated_shop.entity.OrderItem;
import com.example.ai_generated_shop.repository.OrderItemRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class OrderItemServiceTest {

  @Mock
  private OrderItemRepository orderItemRepository;

  @InjectMocks
  private OrderItemService orderItemService;

  @Test
  public void testGetAllOrderItems() {
    List<OrderItem> mockOrderItems = new ArrayList<>();
    when(orderItemRepository.findAll()).thenReturn(mockOrderItems);

    List<OrderItem> result = orderItemService.getAllOrderItems();

    assertEquals(mockOrderItems, result);
  }

  @Test
  public void testGetOrderItemById_ItemExists() {
    OrderItem mockOrderItem = new OrderItem();
    when(orderItemRepository.findById(any())).thenReturn(Optional.of(mockOrderItem));

    OrderItem result = orderItemService.getOrderItemById(1L);

    assertEquals(mockOrderItem, result);
  }

  @Test
  public void testGetOrderItemById_ItemDoesNotExist() {
    when(orderItemRepository.findById(any())).thenReturn(Optional.empty());

    assertThrows(EntityNotFoundException.class, () -> orderItemService.getOrderItemById(1L));
  }

  @Test
  public void testSaveOrderItem() {
    OrderItem mockOrderItem = new OrderItem();
    when(orderItemRepository.save(any())).thenReturn(mockOrderItem);

    OrderItem result = orderItemService.saveOrderItem(new OrderItem());

    assertEquals(mockOrderItem, result);
  }

  @Test
  public void testDeleteOrderItemById_ItemDoesNotExist() {
    assertThrows(EntityNotFoundException.class, () -> orderItemService.deleteOrderItemById(1L));
  }
}
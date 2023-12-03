package com.example.ai_generated_shop.service;

import com.example.ai_generated_shop.entity.OrderItem;
import com.example.ai_generated_shop.repository.OrderItemRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Data
public class OrderItemService {

  @Autowired
  private final OrderItemRepository orderItemRepository;

  public List<OrderItem> getAllOrderItems() {
    return orderItemRepository.findAll();
  }

  public OrderItem getOrderItemById(Long id) {
    return orderItemRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("OrderItem not found with id: " + id));
  }

  public OrderItem saveOrderItem(OrderItem orderItem) {
    return orderItemRepository.save(orderItem);
  }

  public void deleteOrderItemById(Long id) {
    if (!orderItemRepository.existsById(id)) {
      throw new EntityNotFoundException("OrderItem not found with id: " + id);
    }
    orderItemRepository.deleteById(id);
  }
}
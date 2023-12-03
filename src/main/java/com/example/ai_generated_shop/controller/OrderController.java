package com.example.ai_generated_shop.controller;

import com.example.ai_generated_shop.dto.OrderDTO;
import com.example.ai_generated_shop.entity.Order;
import com.example.ai_generated_shop.mapper.OrderMapper;
import com.example.ai_generated_shop.service.OrderService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

  @Autowired
  private OrderService orderService;

  @Autowired
  private OrderMapper orderMapper;

  @PostMapping("/user/{userId}")
  public OrderDTO createOrder(@PathVariable Long userId) {
    Order createdOrder = orderService.createOrder(userId);
    return orderMapper.toOrderDTO(createdOrder);
  }

  @GetMapping("/user/{userId}")
  public List<OrderDTO> getUserOrders(@PathVariable Long userId) {
    List<Order> userOrders = orderService.getUserOrders(userId);
    return userOrders.stream()
        .map(orderMapper::toOrderDTO)
        .collect(Collectors.toList());
  }

  @PutMapping("/cancel/{orderId}")
  public void cancelOrder(@PathVariable Long orderId) {
    orderService.cancelOrder(orderId);
  }
}

package com.example.ai_generated_shop.dto;

import com.example.ai_generated_shop.enumeration.OrderStatus;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {

  private Long id;
  private Set<OrderItemDTO> items;
  private Long userId;
  private double totalAmount;
  private OrderStatus status;
}
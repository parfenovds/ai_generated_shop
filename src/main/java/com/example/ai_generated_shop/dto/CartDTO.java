package com.example.ai_generated_shop.dto;

import lombok.Data;
import java.util.Set;

@Data
public class CartDTO {

  private Long id;
  private Long userId;
  private double totalAmount;
  private Set<CartItemDTO> cartItems;
}

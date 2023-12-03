package com.example.ai_generated_shop.dto;

import java.util.HashSet;
import java.util.Set;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

public class CartDTOTest {

  @Test
  public void testCartDTOFields() {
    // Arrange
    Long userId = 1L;
    double totalAmount = 100.0;
    Set<CartItemDTO> cartItems = new HashSet<>();

    // Act
    CartDTO cartDTO = new CartDTO();
    cartDTO.setUserId(userId);
    cartDTO.setTotalAmount(totalAmount);
    cartDTO.setCartItems(cartItems);

    // Assert
    assertThat(cartDTO.getUserId()).isEqualTo(userId);
    assertThat(cartDTO.getTotalAmount()).isEqualTo(totalAmount);
    assertThat(cartDTO.getCartItems()).isEqualTo(cartItems);
  }

  @Test
  public void testCartDTOToString() {
    // Arrange
    Long userId = 1L;
    double totalAmount = 100.0;
    Set<CartItemDTO> cartItems = new HashSet<>();

    // Act
    CartDTO cartDTO = new CartDTO();
    cartDTO.setUserId(userId);
    cartDTO.setTotalAmount(totalAmount);
    cartDTO.setCartItems(cartItems);

    // Assert
    assertThat(cartDTO.toString()).contains("CartDTO");
  }
}

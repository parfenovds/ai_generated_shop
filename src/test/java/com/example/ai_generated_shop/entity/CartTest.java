package com.example.ai_generated_shop.entity;

import org.junit.jupiter.api.Test;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import static org.assertj.core.api.Assertions.assertThat;

public class CartTest {

  @Test
  public void testGetTotalAmountWithNoCartItems() {
    // Arrange
    Cart cart = new Cart();

    // Act
    double totalAmount = cart.getTotalAmount();

    // Assert
    assertThat(totalAmount).isEqualTo(0.0);
  }

  @Test
  public void testGetTotalAmountWithCartItems() {
    // Arrange
    Cart cart = new Cart();
    Set<CartItem> cartItems = new HashSet<>();
    cartItems.add(new CartItem(1L, new Product(1L, "first", "second", 1.0), 1, 1.0, cart));
    cartItems.add(new CartItem(1L, new Product(2L, "second", "third", 10.0), 1, 10.0, cart));
    cart.setCartItems(cartItems);

    // Act
    double totalAmount = cart.getTotalAmount();

    // Assert
    assertThat(totalAmount).isEqualTo(11.0); // (10.0 * 2) + (5.0 * 3) = 35.0
  }

  @Test
  public void testGetTotalAmountWithNullCartItems() {
    // Arrange
    Cart cart = new Cart();
    cart.setCartItems(null);

    // Act
    double totalAmount = cart.getTotalAmount();

    // Assert
    assertThat(totalAmount).isEqualTo(0.0);
  }
}
package com.example.ai_generated_shop.entity;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class CartItemTest {

  @Test
  public void testCartItemInitialization() {
    // Arrange
    Product product = new Product();
    Cart cart = new Cart();

    // Act
    CartItem cartItem = new CartItem();
    cartItem.setId(1L);
    cartItem.setProduct(product);
    cartItem.setQuantity(3);
    cartItem.setPrice(15.0);
    cartItem.setCart(cart);

    // Assert
    assertThat(cartItem.getId()).isEqualTo(1L);
    assertThat(cartItem.getProduct()).isEqualTo(product);
    assertThat(cartItem.getQuantity()).isEqualTo(3);
    assertThat(cartItem.getPrice()).isEqualTo(15.0);
    assertThat(cartItem.getCart()).isEqualTo(cart);
  }

  @Test
  public void testCartItemEqualsAndHashCode() {
    // Arrange
    Product product1 = new Product();
    product1.setId(1L);
    Product product2 = new Product();
    product2.setId(2L);

    Cart cart = new Cart();
    cart.setId(1L);

    CartItem cartItem1 = new CartItem();
    cartItem1.setId(1L);
    cartItem1.setProduct(product1);
    cartItem1.setQuantity(3);
    cartItem1.setPrice(15.0);
    cartItem1.setCart(cart);

    CartItem cartItem2 = new CartItem();
    cartItem2.setId(1L);
    cartItem2.setProduct(product1);
    cartItem2.setQuantity(3);
    cartItem2.setPrice(15.0);
    cartItem2.setCart(cart);

    CartItem cartItem3 = new CartItem();
    cartItem3.setId(2L);
    cartItem3.setProduct(product2);
    cartItem3.setQuantity(4);
    cartItem3.setPrice(20.0);
    cartItem3.setCart(cart);

    // Assert
    assertThat(cartItem1).isEqualTo(cartItem2);
    assertThat(cartItem1).isNotEqualTo(cartItem3);
    assertThat(cartItem1.hashCode()).isEqualTo(cartItem2.hashCode());
    assertThat(cartItem1.hashCode()).isNotEqualTo(cartItem3.hashCode());
  }
}
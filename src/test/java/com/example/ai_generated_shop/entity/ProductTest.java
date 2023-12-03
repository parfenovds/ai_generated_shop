package com.example.ai_generated_shop.entity;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductTest {

  @Test
  public void testProductCreationAndGetters() {
    // Create a product
    Long id = 1L;
    String name = "Test Product";
    String description = "Test Description";
    double price = 99.99;

    Product product = new Product(id, name, description, price);

    // Check the values using getters
    assertThat(product.getId()).isEqualTo(id);
    assertThat(product.getName()).isEqualTo(name);
    assertThat(product.getDescription()).isEqualTo(description);
    assertThat(product.getPrice()).isEqualTo(price);
  }

  @Test
  public void testEqualsAndHashCode() {
    Product product1 = new Product(1L, "Product 1", "Description 1", 20.0);
    Product product2 = new Product(1L, "Product 1", "Description 1", 20.0);

    assertThat(product1).isEqualTo(product2);
    assertThat(product1.hashCode()).isEqualTo(product2.hashCode());
  }

  // Add more tests as needed
}
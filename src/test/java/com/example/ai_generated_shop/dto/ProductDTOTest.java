package com.example.ai_generated_shop.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class ProductDTOTest {

  @Test
  public void testProductDTOFields() {
    // Arrange
    Long id = 1L;
    String name = "Product Name";
    String description = "Product Description";
    double price = 99.99;

    // Act
    ProductDTO productDTO = ProductDTO.builder()
        .id(id)
        .name(name)
        .description(description)
        .price(price)
        .build();

    // Assert
    assertThat(productDTO.getId()).isEqualTo(id);
    assertThat(productDTO.getName()).isEqualTo(name);
    assertThat(productDTO.getDescription()).isEqualTo(description);
    assertThat(productDTO.getPrice()).isEqualTo(price);
  }

  @Test
  public void testProductDTOToString() {
    // Arrange
    Long id = 1L;
    String name = "Product Name";
    String description = "Product Description";
    double price = 99.99;

    // Act
    ProductDTO productDTO = ProductDTO.builder()
        .id(id)
        .name(name)
        .description(description)
        .price(price)
        .build();

    // Assert
    assertThat(productDTO.toString()).contains("ProductDTO");
  }
}
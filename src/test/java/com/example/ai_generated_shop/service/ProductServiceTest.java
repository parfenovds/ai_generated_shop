package com.example.ai_generated_shop.service;

import com.example.ai_generated_shop.entity.Product;
import com.example.ai_generated_shop.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ProductServiceTest {

  @Mock
  private ProductRepository productRepository;

  @InjectMocks
  private ProductService productService;

  public ProductServiceTest() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void testGetAllProducts() {
    // Мокируем поведение репозитория
    Product product1 = new Product(1L, "Product 1", "Description 1", 10.0);
    Product product2 = new Product(2L, "Product 2", "Description 2", 20.0);
    List<Product> mockProducts = Arrays.asList(product1, product2);

    when(productRepository.findAll()).thenReturn(mockProducts);

    List<Product> result = productService.getAllProducts();

    assertEquals(2, result.size());
    assertEquals(product1, result.get(0));
    assertEquals(product2, result.get(1));
  }

  @Test
  public void testGetProductById_ProductExists() {
    Product mockProduct = new Product(1L, "Test Product", "Test Description", 15.0);

    when(productRepository.findById(1L)).thenReturn(Optional.of(mockProduct));

    Product result = productService.getProductById(1L);

    assertEquals(mockProduct, result);
  }

  @Test
  public void testGetProductById_ProductDoesNotExist() {
    when(productRepository.findById(1L)).thenReturn(Optional.empty());

    assertThrows(RuntimeException.class, () -> productService.getProductById(1L));
  }
}
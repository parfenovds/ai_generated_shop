package com.example.ai_generated_shop.controller;

import com.example.ai_generated_shop.dto.ProductDTO;
import com.example.ai_generated_shop.entity.Product;
import com.example.ai_generated_shop.mapper.ProductMapper;
import com.example.ai_generated_shop.service.ProductService;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ProductControllerTest {

  @Mock
  private ProductService productService;

  @Mock
  private ProductMapper productMapper;

  @InjectMocks
  private ProductController productController;

  @Test
  public void getAllProducts_ReturnsListOfProducts() {
    List<Product> productList = Arrays.asList(
        new Product(1L, "Product 1", "Description 1", 10.0),
        new Product(2L, "Product 2", "Description 2", 20.0)
    );
    List<ProductDTO> productDTOList = Arrays.asList(
        new ProductDTO(1L, "Product 1", "Description 1", 10.0),
        new ProductDTO(2L, "Product 2", "Description 2", 20.0)
    );

    when(productService.getAllProducts()).thenReturn(productList);
    when(productMapper.toProductDTO(productList)).thenReturn(productDTOList);

    List<ProductDTO> result = productController.getAllProducts();

    assertEquals(2, result.size());
    assertEquals("Product 1", result.get(0).getName());
    assertEquals("Product 2", result.get(1).getName());

    verify(productService, times(1)).getAllProducts();
    verify(productMapper, times(1)).toProductDTO(productList);
  }
}
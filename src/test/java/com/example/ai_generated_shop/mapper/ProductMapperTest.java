package com.example.ai_generated_shop.mapper;

import com.example.ai_generated_shop.dto.ProductDTO;
import com.example.ai_generated_shop.entity.Product;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ProductMapperTest {

  private final ProductMapper productMapper = ProductMapper.INSTANCE;

  @Test
  public void testToProduct() {
    ProductDTO productDTO = new ProductDTO();
    productDTO.setName("Example Product");
    productDTO.setDescription("This is an example product");
    productDTO.setPrice(50.0);

    Product product = productMapper.toProduct(productDTO);

    assertNotNull(product);
    assertEquals(productDTO.getName(), product.getName());
    assertEquals(productDTO.getDescription(), product.getDescription());
    assertEquals(productDTO.getPrice(), product.getPrice());
  }

  @Test
  public void testToProductDTO() {
    Product product = new Product();
    product.setId(1L);
    product.setName("Example Product");
    product.setDescription("This is an example product");
    product.setPrice(50.0);

    ProductDTO productDTO = productMapper.toProductDTO(product);

    assertNotNull(productDTO);
    assertEquals(product.getName(), productDTO.getName());
    assertEquals(product.getDescription(), productDTO.getDescription());
    assertEquals(product.getPrice(), productDTO.getPrice());
  }

  @Test
  public void testToProductList() {
    List<ProductDTO> productDTOList = new ArrayList<>();
    // Заполните productDTOList

    List<Product> productList = productMapper.toProduct(productDTOList);

    assertNotNull(productList);
    assertEquals(productDTOList.size(), productList.size());

    // В цикле можно проверить каждый отдельный объект в списках
    for (int i = 0; i < productDTOList.size(); i++) {
      ProductDTO productDTO = productDTOList.get(i);
      Product product = productList.get(i);

      assertNotNull(product);
      assertEquals(productDTO.getName(), product.getName());
      assertEquals(productDTO.getDescription(), product.getDescription());
      assertEquals(productDTO.getPrice(), product.getPrice());
    }
  }

  @Test
  public void testToProductDTOList() {
    List<Product> productList = new ArrayList<>();
    // Заполните productList

    List<ProductDTO> productDTOList = productMapper.toProductDTO(productList);

    assertNotNull(productDTOList);
    assertEquals(productList.size(), productDTOList.size());

    // В цикле можно проверить каждый отдельный объект в списках
    for (int i = 0; i < productList.size(); i++) {
      Product product = productList.get(i);
      ProductDTO productDTO = productDTOList.get(i);

      assertNotNull(productDTO);
      assertEquals(product.getName(), productDTO.getName());
      assertEquals(product.getDescription(), productDTO.getDescription());
      assertEquals(product.getPrice(), productDTO.getPrice());
    }
  }
}
package com.example.ai_generated_shop.controller;

import com.example.ai_generated_shop.dto.ProductDTO;
import com.example.ai_generated_shop.entity.Product;
import com.example.ai_generated_shop.mapper.ProductMapper;
import com.example.ai_generated_shop.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

  private final ProductService productService;
  private final ProductMapper productMapper;

  @Autowired
  public ProductController(ProductService productService, ProductMapper productMapper) {
    this.productService = productService;
    this.productMapper = productMapper;
  }

  @GetMapping
  public List<ProductDTO> getAllProducts() {
    List<Product> products = productService.getAllProducts();
    return productMapper.toProductDTO(products);
  }

  @GetMapping("/{productId}")
  public ProductDTO getProductById(@PathVariable Long productId) {
    Product product = productService.getProductById(productId);
    return productMapper.toProductDTO(product);
  }

  @PostMapping
  public ProductDTO addProduct(@RequestBody ProductDTO productDTO) {
    Product product = productMapper.toProduct(productDTO);
    Product savedProduct = productService.addProduct(product);
    return productMapper.toProductDTO(savedProduct);
  }

  @PutMapping("/{productId}")
  public ProductDTO updateProduct(@PathVariable Long productId, @RequestBody ProductDTO updatedProductDTO) {
    Product updatedProduct = productMapper.toProduct(updatedProductDTO);
    Product savedProduct = productService.updateProduct(productId, updatedProduct);
    return productMapper.toProductDTO(savedProduct);
  }

  @DeleteMapping("/{productId}")
  public void deleteProduct(@PathVariable Long productId) {
    productService.deleteProduct(productId);
  }
}
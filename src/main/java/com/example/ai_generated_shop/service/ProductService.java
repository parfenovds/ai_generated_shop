package com.example.ai_generated_shop.service;

import com.example.ai_generated_shop.entity.Product;
import com.example.ai_generated_shop.repository.ProductRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

  @Autowired
  private ProductRepository productRepository;

  public List<Product> getAllProducts() {
    return productRepository.findAll();
  }

  public Product getProductById(Long productId) {
    return productRepository.findById(productId)
        .orElseThrow(() -> new RuntimeException("Product not found with ID: " + productId));
  }

  public Product addProduct(Product product) {
    return productRepository.save(product);
  }

  public Product updateProduct(Long productId, Product updatedProduct) {
    Product existingProduct = getProductById(productId);
    existingProduct.setName(updatedProduct.getName());
    existingProduct.setDescription(updatedProduct.getDescription());
    existingProduct.setPrice(updatedProduct.getPrice());
    return productRepository.save(existingProduct);
  }

  public void deleteProduct(Long productId) {
    Product product = getProductById(productId);
    productRepository.delete(product);
  }
}
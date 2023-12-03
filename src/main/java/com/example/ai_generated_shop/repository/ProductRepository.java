package com.example.ai_generated_shop.repository;

import com.example.ai_generated_shop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
  // Additional methods for product management can be added here if needed
}
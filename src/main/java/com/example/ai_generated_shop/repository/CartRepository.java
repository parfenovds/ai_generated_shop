package com.example.ai_generated_shop.repository;

import com.example.ai_generated_shop.entity.Cart;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
  Optional<Cart> getByUserId(Long userId);
  // Additional methods for cart management can be added here if needed
}
package com.example.ai_generated_shop.repository;

import com.example.ai_generated_shop.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
  // Дополнительные методы для работы с OrderItem могут быть добавлены здесь, если необходимо
}
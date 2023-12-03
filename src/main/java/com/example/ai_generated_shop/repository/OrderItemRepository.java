package com.example.ai_generated_shop.repository;

import com.example.ai_generated_shop.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
  // Дополнительные методы для работы с OrderItem могут быть добавлены здесь, если необходимо
}
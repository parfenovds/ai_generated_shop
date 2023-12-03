package com.example.ai_generated_shop.repository;

import com.example.ai_generated_shop.entity.Order;
import com.example.ai_generated_shop.entity.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
  // Additional methods for order management can be added here if needed
  List<Order> findByUser(User user);
}
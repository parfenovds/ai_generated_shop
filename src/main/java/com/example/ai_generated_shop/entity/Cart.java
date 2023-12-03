package com.example.ai_generated_shop.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "carts")
public class Cart {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToOne
  private User user;

  @OneToMany(mappedBy = "cart", cascade = {CascadeType.ALL}, orphanRemoval = true)
  Set<CartItem> cartItems = new HashSet<>();

  @Transient
  private double totalAmount;

  public double getTotalAmount() {
    calculateTotalAmount();
    return totalAmount;
  }

  private void calculateTotalAmount() {
    if (cartItems == null || cartItems.isEmpty()) {
      totalAmount = 0.0;
    } else {
      totalAmount = cartItems.stream()
          .mapToDouble(cartItem -> cartItem.getPrice() * cartItem.getQuantity())
          .sum();
    }
  }
}
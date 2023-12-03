package com.example.ai_generated_shop.service;


import com.example.ai_generated_shop.entity.CartItem;
import com.example.ai_generated_shop.repository.CartItemRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Data
public class CartItemService {

  @Autowired
  private final CartItemRepository cartItemRepository;

  public List<CartItem> getAllCartItems() {
    return cartItemRepository.findAll();
  }

  public CartItem getOrderItemById(Long id) {
    return cartItemRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("OrderItem not found with id: " + id));
  }

  public CartItem saveCartItem(CartItem cartItem) {
    return cartItemRepository.save(cartItem);
  }

  public void deleteCartItemById(Long id) {
    if (!cartItemRepository.existsById(id)) {
      throw new EntityNotFoundException("CartItem not found with id: " + id);
    }
    cartItemRepository.deleteById(id);
  }

  public void deleteCartItem(Long id) {
   cartItemRepository.deleteById(id);
  }
}
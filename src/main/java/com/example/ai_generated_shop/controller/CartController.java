package com.example.ai_generated_shop.controller;

import com.example.ai_generated_shop.dto.CartDTO;
import com.example.ai_generated_shop.entity.Cart;
import com.example.ai_generated_shop.mapper.CartMapper;
import com.example.ai_generated_shop.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartController {

  private final CartService cartService;
  private final CartMapper cartMapper;

  @Autowired
  public CartController(CartService cartService, CartMapper cartMapper) {
    this.cartService = cartService;
    this.cartMapper = cartMapper;
  }

  @PostMapping("/user/{userId}/product/{productId}")
  public void addToCart(@PathVariable Long userId, @PathVariable Long productId) {
    cartService.addToCart(userId, productId);
  }

  @GetMapping("/{userId}")
  public CartDTO getUserCart(@PathVariable Long userId) {
    Cart cart = cartService.getUserCart(userId);
    CartDTO cartDTO = cartMapper.cartToCartDTO(cart);
    return cartDTO;
  }
}
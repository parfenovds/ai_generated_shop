package com.example.ai_generated_shop.service;

import com.example.ai_generated_shop.entity.Cart;
import com.example.ai_generated_shop.entity.CartItem;
import com.example.ai_generated_shop.entity.Product;
import com.example.ai_generated_shop.repository.CartRepository;
import java.util.Optional;
import java.util.Set;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CartService {

  @Autowired
  private CartRepository cartRepository;

  @Autowired
  private ProductService productService;

  @Autowired
  private UserService userService;

  @Autowired
  private CartItemService cartItemService;

  public void addToCart(Long userId, Long productId) {
    Cart cart = cartRepository.getByUserId(userId)
        .orElseGet(() -> createNewCartForUser(userId));

    Product product = productService.getProductById(productId);
    CartItem cartItem = findOrCreateCartItem(cart, product);

    cartItem.setQuantity(cartItem.getQuantity() + 1);
    cartItem.setPrice(cartItem.getProduct().getPrice() * cartItem.getQuantity());

    cart.getCartItems().add(cartItem);
    cartRepository.save(cart);
  }

  private Cart createNewCartForUser(Long userId) {
    Cart cart = new Cart();
    cart.setUser(userService.findById(userId));
    return cart;
  }

  private CartItem findOrCreateCartItem(Cart cart, Product product) {
    return cart.getCartItems().stream()
        .filter(item -> item.getProduct().equals(product))
        .findFirst()
        .orElseGet(() -> createNewCartItem(cart, product));
  }

  private CartItem createNewCartItem(Cart cart, Product product) {
    CartItem cartItem = new CartItem();
    cartItem.setProduct(product);
    cartItem.setQuantity(0);
    cartItem.setPrice(0);
    cartItem.setCart(cart);
    cartItemService.saveCartItem(cartItem);
    return cartItem;
  }

  public Cart getUserCart(Long userId) {
    return cartRepository.getByUserId(userId)
        .orElseThrow(() -> new RuntimeException("Cart not found with ID: " + userId));
  }

  public void removeAllCartItems(Long cartId) {
    cartRepository.findById(cartId).ifPresent(cart -> {
      cart.getCartItems().clear();
      cartRepository.save(cart);
    });
  }

  public Cart saveCart(Cart cart) {
    return cartRepository.save(cart);
  }
}
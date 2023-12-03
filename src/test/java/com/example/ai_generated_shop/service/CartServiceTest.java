package com.example.ai_generated_shop.service;

import com.example.ai_generated_shop.entity.Cart;
import com.example.ai_generated_shop.entity.Product;
import com.example.ai_generated_shop.entity.User;
import com.example.ai_generated_shop.repository.CartRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
@SpringJUnitConfig
public class CartServiceTest {

  @Mock
  private CartRepository cartRepository;

  @Mock
  private ProductService productService;

  @Mock
  private UserService userService;

  @Mock
  private CartItemService cartItemService;

  @InjectMocks
  private CartService cartService;

  @Test
  @Transactional
  public void testAddToCart_NewUser_NewProduct() {
    Long userId = 1L;
    Long productId = 2L;

    Cart cart = new Cart();
    Product product = new Product();
    product.setId(productId);

    when(cartRepository.getByUserId(userId)).thenReturn(Optional.empty());
    when(productService.getProductById(productId)).thenReturn(product);
    when(userService.findById(userId)).thenReturn(new User());
    when(cartRepository.save(any())).thenReturn(cart);

    cartService.addToCart(userId, productId);

    verify(cartRepository, times(1)).getByUserId(userId);
    verify(productService, times(1)).getProductById(productId);
    verify(userService, times(1)).findById(userId);
    verify(cartRepository, times(1)).save(any());
    verify(cartItemService, times(1)).saveCartItem(any());
  }

  // Добавьте другие тесты для остальных сценариев, таких как существующая корзина, существующий продукт и т.д.

}
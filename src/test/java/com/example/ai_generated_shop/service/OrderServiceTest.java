package com.example.ai_generated_shop.service;

import java.util.stream.Collectors;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import com.example.ai_generated_shop.entity.*;
import com.example.ai_generated_shop.enumeration.OrderStatus;
import com.example.ai_generated_shop.repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OrderServiceTest {

  @Mock
  private OrderRepository orderRepository;

  @Mock
  private CartService cartService;

  @Mock
  private StripeService stripeService;

  @Mock
  private UserService userService;

  @Mock
  private CartItemService cartItemService;

  @InjectMocks
  private OrderService orderService;

  @BeforeEach
  public void setup() {
    MockitoAnnotations.initMocks(this);
  }



  @Test
  public void testCreateOrder_EmptyCart() {
    Long userId = 1L;
    Cart cart = new Cart();
    cart.setId(1L);
    cart.setUser(new User());
    cart.setTotalAmount(0.0);

    when(cartService.getUserCart(userId)).thenReturn(cart);

    RuntimeException exception = assertThrows(RuntimeException.class, () -> orderService.createOrder(userId));
    assertEquals("Cart is empty", exception.getMessage());
  }

  @Test
  public void testCreateOrder_FailedPayment() {
    Long userId = 1L;
    Cart cart = new Cart();
    cart.setId(1L);
    cart.setUser(new User());
    cart.setTotalAmount(100.0);
    Set<CartItem> cartItems = new HashSet<>();
    CartItem cartItem = new CartItem();
    cartItem.setProduct(new Product());
    cartItem.setQuantity(2);
    cartItem.setPrice(50.0);
    cartItems.add(cartItem);
    cart.setCartItems(cartItems);

    when(cartService.getUserCart(userId)).thenReturn(cart);
    when(stripeService.processPayment(any())).thenReturn(new PaymentResult(false, "Payment failed"));

    RuntimeException exception = assertThrows(RuntimeException.class, () -> orderService.createOrder(userId));
    assertEquals("Payment failed: Payment failed", exception.getMessage());
    verify(cartService, never()).removeAllCartItems(any());
  }

  // Add more tests for getUserOrders, cancelOrder, and other scenarios as needed
}

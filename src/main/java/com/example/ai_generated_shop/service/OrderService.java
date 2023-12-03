package com.example.ai_generated_shop.service;

import com.example.ai_generated_shop.entity.Cart;
import com.example.ai_generated_shop.entity.CartItem;
import com.example.ai_generated_shop.entity.Order;
import com.example.ai_generated_shop.entity.OrderItem;
import com.example.ai_generated_shop.enumeration.OrderStatus;
import com.example.ai_generated_shop.repository.OrderRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

  @Autowired
  private OrderRepository orderRepository;

  @Autowired
  private CartService cartService;

  @Autowired
  private StripeService stripeService;

  @Autowired
  private UserService userService;

  @Autowired
  private CartItemService cartItemService;

  @Transactional
  public Order createOrder(Long userId) {
    Cart cart = cartService.getUserCart(userId);
    validateCartNotEmpty(cart);
    PaymentResult paymentResult = processPayment(cart);

    if (paymentResult.isSuccess()) {
      Order order = createOrderFromCart(cart);
      cartService.removeAllCartItems(cart.getId());
      return orderRepository.save(order);
    } else {
      throw new RuntimeException("Payment failed: " + paymentResult.getError());
    }
  }

  private void validateCartNotEmpty(Cart cart) {
    if (cart.getCartItems().isEmpty()) {
      throw new RuntimeException("Cart is empty");
    }
  }

  private PaymentResult processPayment(Cart cart) {
    return stripeService.processPayment(cart);
  }

  private Order createOrderFromCart(Cart cart) {
    Order order = new Order();
    order.setItems(createOrderItemsFromCartItems(cart.getCartItems()));
    order.setUser(cart.getUser());
    order.setStatus(OrderStatus.CREATED);
    order.setTotalAmount(cart.getTotalAmount());
    return order;
  }

  private Set<OrderItem> createOrderItemsFromCartItems(Set<CartItem> cartItems) {
    return cartItems.stream()
        .map(this::createOrderItemFromCartItem)
        .collect(Collectors.toSet());
  }

  private OrderItem createOrderItemFromCartItem(CartItem cartItem) {
    OrderItem orderItem = new OrderItem();
    orderItem.setProduct(cartItem.getProduct());
    orderItem.setQuantity(cartItem.getQuantity());
    orderItem.setPrice(cartItem.getPrice());
    return orderItem;
  }

  public List<Order> getUserOrders(Long userId) {
    return orderRepository.findByUser(userService.findById(userId));
  }

  public void cancelOrder(Long orderId) {
    Order order = getOrderById(orderId);
    order.setStatus(OrderStatus.CANCELLED);
    orderRepository.save(order);
  }

  private Order getOrderById(Long orderId) {
    return orderRepository.findById(orderId)
        .orElseThrow(() -> new RuntimeException("Order not found with ID: " + orderId));
  }
}
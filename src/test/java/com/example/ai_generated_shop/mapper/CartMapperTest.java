package com.example.ai_generated_shop.mapper;

import com.example.ai_generated_shop.dto.CartDTO;
import com.example.ai_generated_shop.dto.CartItemDTO;
import com.example.ai_generated_shop.entity.Cart;
import com.example.ai_generated_shop.entity.CartItem;
import com.example.ai_generated_shop.entity.Product;
import com.example.ai_generated_shop.entity.User;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CartMapperTest {

  private final CartMapper cartMapper = CartMapper.INSTANCE;

  @Test
  public void testCartToCartDTO() {
    // Create a CartItem
    CartItem cartItem = new CartItem();
    cartItem.setId(1L);

    Product product = new Product();
    product.setId(100L);

    cartItem.setProduct(product);
    cartItem.setQuantity(5);
    cartItem.setPrice(20.0);

    // Create a Set of CartItems
    Set<CartItem> cartItems = new HashSet<>();
    cartItems.add(cartItem);

    // Create a User
    User user = new User();
    user.setId(50L);

    // Create a Cart
    Cart cart = new Cart();
    cart.setId(10L);
    cart.setUser(user);
    cart.setCartItems(cartItems);

    // Map Cart to CartDTO
    CartDTO cartDTO = cartMapper.cartToCartDTO(cart);

    // Validate the mapping
    assertEquals(cart.getId(), cartDTO.getId());
    assertEquals(cart.getUser().getId(), cartDTO.getUserId());
    assertEquals(cart.getTotalAmount(), cartDTO.getTotalAmount());

    // Assuming the mapping for cartItemsToCartItemDTOs is correct,
    // you can validate the mapping by testing each item in the set.
    // For simplicity, we are assuming a single item in the set in this example.
    CartItemDTO cartItemDTO = cartDTO.getCartItems().iterator().next();
    assertEquals(cartItem.getId(), cartItemDTO.getId());
    assertEquals(cartItem.getProduct().getId(), cartItemDTO.getProductId());
    assertEquals(cartItem.getQuantity(), cartItemDTO.getQuantity());
    assertEquals(cartItem.getPrice(), cartItemDTO.getPrice());
  }
}
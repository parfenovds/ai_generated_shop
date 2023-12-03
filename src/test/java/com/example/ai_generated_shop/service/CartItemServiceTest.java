package com.example.ai_generated_shop.service;

import com.example.ai_generated_shop.entity.CartItem;
import com.example.ai_generated_shop.repository.CartItemRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
@SpringJUnitConfig
public class CartItemServiceTest {

  @Mock
  private CartItemRepository cartItemRepository;

  @InjectMocks
  private CartItemService cartItemService;

  @Test
  public void testGetAllCartItems() {
    // Создаем список для заглушки
    List<CartItem> mockCartItems = new ArrayList<>();
    mockCartItems.add(new CartItem());
    when(cartItemRepository.findAll()).thenReturn(mockCartItems);

    List<CartItem> result = cartItemService.getAllCartItems();

    assertEquals(mockCartItems.size(), result.size());
  }

  @Test
  public void testGetCartItemById_ItemExists() {
    // Создаем заглушку для findById
    CartItem mockCartItem = new CartItem();
    when(cartItemRepository.findById(any())).thenReturn(Optional.of(mockCartItem));

    CartItem result = cartItemService.getOrderItemById(1L);

    assertNotNull(result);
  }

  @Test
  public void testGetCartItemById_ItemDoesNotExist() {
    when(cartItemRepository.findById(any())).thenReturn(Optional.empty());

    assertThrows(EntityNotFoundException.class, () -> cartItemService.getOrderItemById(1L));
  }

  @Test
  public void testSaveCartItem() {
    // Создаем заглушку для save
    CartItem mockCartItem = new CartItem();
    when(cartItemRepository.save(any())).thenReturn(mockCartItem);

    CartItem result = cartItemService.saveCartItem(new CartItem());

    assertNotNull(result);
  }

  @Test
  public void testDeleteCartItemById_ItemExists() {
    when(cartItemRepository.existsById(any())).thenReturn(true);

    cartItemService.deleteCartItemById(1L);

    verify(cartItemRepository, times(1)).deleteById(1L);
  }

  @Test
  public void testDeleteCartItemById_ItemDoesNotExist() {
    when(cartItemRepository.existsById(any())).thenReturn(false);

    assertThrows(EntityNotFoundException.class, () -> cartItemService.deleteCartItemById(1L));
  }

  @Test
  public void testDeleteCartItem() {
    cartItemService.deleteCartItem(1L);

    verify(cartItemRepository, times(1)).deleteById(1L);
  }
}
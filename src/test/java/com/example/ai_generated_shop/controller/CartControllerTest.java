package com.example.ai_generated_shop.controller;

import com.example.ai_generated_shop.dto.CartDTO;
import com.example.ai_generated_shop.entity.Cart;
import com.example.ai_generated_shop.mapper.CartMapper;
import com.example.ai_generated_shop.service.CartService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class CartControllerTest {

  private MockMvc mockMvc;

  @Mock
  private CartService cartService;

  @Mock
  private CartMapper cartMapper;

  @InjectMocks
  private CartController cartController;

  @Before
  public void setup() {
    mockMvc = MockMvcBuilders.standaloneSetup(cartController).build();
  }

  @Test
  public void addToCart_ValidUserIdAndProductId_ReturnsStatusOk() throws Exception {
    doNothing().when(cartService).addToCart(anyLong(), anyLong());

    mockMvc.perform(post("/cart/user/1/product/1"))
        .andExpect(status().isOk());
  }

  @Test
  public void getUserCart_ValidUserId_ReturnsStatusOk() throws Exception {
    CartDTO cartDTO = new CartDTO(); // Create a CartDTO for testing

    when(cartService.getUserCart(anyLong())).thenReturn(new Cart());
    when(cartMapper.cartToCartDTO(new Cart())).thenReturn(cartDTO);

    mockMvc.perform(get("/cart/1")
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
  }
}

package com.example.ai_generated_shop.controller;
import com.example.ai_generated_shop.entity.Order;
import com.example.ai_generated_shop.enumeration.OrderStatus;
import com.example.ai_generated_shop.service.OrderService;
import com.example.ai_generated_shop.dto.OrderDTO;
import com.example.ai_generated_shop.mapper.OrderMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class OrderControllerTest {

  private MockMvc mockMvc;

  @Mock
  private OrderService orderService;

  @Mock
  private OrderMapper orderMapper;

  @InjectMocks
  private OrderController orderController;

  @BeforeEach
  public void setup() {
    MockitoAnnotations.initMocks(this);
    mockMvc = MockMvcBuilders.standaloneSetup(orderController).build();
  }

  @Test
  public void testCreateOrder() throws Exception {
    Order order = new Order(); // создайте объект Order по необходимости для тестирования
    OrderDTO orderDTO = OrderDTO.builder()
        .id(1L)
        .items(Collections.emptySet())
        .userId(1L)
        .totalAmount(50.0)
        .status(OrderStatus.CREATED) // установите статус в соответствии с вашей логикой
        .build(); // создайте объект OrderDTO по необходимости для тестирования

    when(orderService.createOrder(anyLong())).thenReturn(order);
    when(orderMapper.toOrderDTO(any())).thenReturn(orderDTO);

    mockMvc.perform(post("/orders/user/1"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id").value(1))
        .andExpect(jsonPath("$.userId").value(1))
        .andExpect(jsonPath("$.items").isEmpty()) // Проверьте соответствие вашего JSON-ответа ожидаемым значениям
        .andExpect(jsonPath("$.totalAmount").value(50.0))
        .andExpect(jsonPath("$.status").value("CREATED")); // Убедитесь, что статус соответствует вашим ожиданиям

    verify(orderService, times(1)).createOrder(anyLong());
    verify(orderMapper, times(1)).toOrderDTO(any());
  }

  @Test
  public void testGetUserOrders() throws Exception {
    List<Order> userOrders = Collections.singletonList(new Order()); // создайте список заказов пользователя по необходимости для тестирования
    List<OrderDTO> orderDTOList = Collections.singletonList(
        OrderDTO.builder()
            .id(1L)
            .items(Collections.emptySet())
            .userId(1L)
            .totalAmount(50.0)
            .status(OrderStatus.CREATED) // установите статус в соответствии с вашей логикой
            .build()); // создайте список OrderDTO по необходимости для тестирования

    when(orderService.getUserOrders(anyLong())).thenReturn(userOrders);
    when(orderMapper.toOrderDTO(any())).thenReturn(orderDTOList.get(0));

    mockMvc.perform(get("/orders/user/1"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$[0].id").value(1))
        .andExpect(jsonPath("$[0].userId").value(1))
        .andExpect(jsonPath("$[0].items").isEmpty()) // Проверьте соответствие вашего JSON-ответа ожидаемым значениям
        .andExpect(jsonPath("$[0].totalAmount").value(50.0))
        .andExpect(jsonPath("$[0].status").value("CREATED")); // Убедитесь, что статус соответствует вашим ожиданиям

    verify(orderService, times(1)).getUserOrders(anyLong());
    verify(orderMapper, times(1)).toOrderDTO(any());
  }

  @Test
  public void testCancelOrder() throws Exception {
    mockMvc.perform(put("/orders/cancel/1"))
        .andExpect(status().isOk());

    verify(orderService, times(1)).cancelOrder(anyLong());
  }
}
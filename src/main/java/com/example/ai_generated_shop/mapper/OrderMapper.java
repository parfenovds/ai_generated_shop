package com.example.ai_generated_shop.mapper;

import com.example.ai_generated_shop.dto.OrderDTO;
import com.example.ai_generated_shop.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {OrderItemMapper.class, UserMapper.class})
public interface OrderMapper {

  OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

  @Mapping(source = "user.id", target = "userId")
  OrderDTO toOrderDTO(Order order);

  Order toOrder(OrderDTO orderDTO);
}
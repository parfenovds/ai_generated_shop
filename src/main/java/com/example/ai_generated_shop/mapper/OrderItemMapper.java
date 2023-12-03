package com.example.ai_generated_shop.mapper;

import com.example.ai_generated_shop.dto.OrderItemDTO;
import com.example.ai_generated_shop.entity.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderItemMapper {

  OrderItemMapper INSTANCE = Mappers.getMapper(OrderItemMapper.class);

  @Mapping(source = "product.id", target = "productId")
  OrderItemDTO toOrderItemDTO(OrderItem orderItem);

  OrderItem toOrderItem(OrderItemDTO orderItemDTO);
}
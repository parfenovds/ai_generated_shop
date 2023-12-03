package com.example.ai_generated_shop.mapper;

import com.example.ai_generated_shop.dto.ProductDTO;
import com.example.ai_generated_shop.entity.Product;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {

  ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

  @Mapping(target = "id", ignore = true) // Игнорируем id, так как он генерируется автоматически
  Product toProduct(ProductDTO productDTO);

  ProductDTO toProductDTO(Product product);

  List<Product> toProduct(List<ProductDTO> productDTO);

  List<ProductDTO> toProductDTO(List<Product> product);
}
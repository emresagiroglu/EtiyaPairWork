package com.etiya.academy.mapper;

import com.etiya.academy.dto.product.*;
import com.etiya.academy.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    CreateProductResponseDto createProductResponseDtoFromProduct(Product product);
    GetProductByIdResponseDto getProductResponseDtoFromProduct(Product product);
    List<ListProductResponseDto> listResponseDtoFromProduct(List<Product> dto);
    Product productFromCreateRequestDto(CreateProductRequestDto dto);
    Product productFromUpdateRequestDto(UpdateProductRequestDto dto);
    UpdateProductResponseDto updateResponseDtoFromProduct(Product dto);
}

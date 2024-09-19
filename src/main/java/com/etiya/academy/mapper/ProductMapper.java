package com.etiya.academy.mapper;

import com.etiya.academy.dto.product.*;
import com.etiya.academy.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(target = "categoryId",source = "category.id")
    CreateProductResponseDto createProductResponseDtoFromProduct(Product product);
    GetProductByIdResponseDto getProductResponseDtoFromProduct(Product product);
    @Mapping(target = "categoryId",source = "category.id")
    default List<ListProductResponseDto> listResponseDtoFromProduct(List<Product> products){
        List<ListProductResponseDto> responseDtos = products.stream().map(product ->
                new ListProductResponseDto(product.getId(),product.getName(),product.getUnitPrice()
                        ,product.getCategory().getId())).toList();
        return responseDtos;
    }
    @Mapping(target = "category.id",source = "categoryId")
    Product productFromCreateRequestDto(CreateProductRequestDto dto);
    Product productFromUpdateRequestDto(UpdateProductRequestDto dto);
    UpdateProductResponseDto updateResponseDtoFromProduct(Product dto);
}

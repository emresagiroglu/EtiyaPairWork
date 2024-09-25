package com.etiya.academy.mapper;

import com.etiya.academy.dto.productCart.*;
import com.etiya.academy.entity.ProductCart;
import com.etiya.academy.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductCartMapper {

    ProductCartMapper INSTANCE = Mappers.getMapper(ProductCartMapper.class);

    @Mapping(target = "cartId",source = "cart.id")
    @Mapping(target = "productId",source = "product.id")
    CreateProductCartResponseDto createProductCartResponseDtoFromProductCart(ProductCart productCart);
    @Mapping(target = "cartId",source = "cart.id")
    @Mapping(target = "productId",source = "product.id")
    GetProductCartResponseDto getProductCartResponseDtoFromProductCart(ProductCart productCart);
    /*@Mapping(target = "cartId",source = "cart.id")
    @Mapping(target = "productId",source = "product.id")
    List<ListProductCartResponseDto> listResponseDtoFromProductCart(List<ProductCart> productCarts);*/
    @Mapping(target = "cartId",source = "cart.id")
    @Mapping(target = "productId",source = "product.id")
    default List<ListProductCartResponseDto> listResponseDtoFromProductCart(List<ProductCart> productCarts){
    List<ListProductCartResponseDto> responseDtos = productCarts.stream().map(productCart ->new ListProductCartResponseDto(productCart.getProduct().getId(),productCart.getCart().getId(),productCart.getQuantity())).toList();
        return responseDtos;
    }
    @Mapping(target = "cart.id",source = "cartId")
    @Mapping(target = "product.id",source = "productId")
    ProductCart productCartFromCreateRequestDto(CreateProductCartRequestDto dto);
    @Mapping(target = "cart.id",source = "cartId")
    @Mapping(target = "product.id",source = "productId")
    ProductCart productCartFromUpdateRequestDto(UpdateProductCartRequestDto dto);
    @Mapping(target = "cartId",source = "cart.id")
    @Mapping(target = "productId",source = "product.id")
    UpdateProductCartResponseDto updateResponseDtoFromProductCart(ProductCart dto);
}

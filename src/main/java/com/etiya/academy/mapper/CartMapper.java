package com.etiya.academy.mapper;

import com.etiya.academy.dto.cart.*;
import com.etiya.academy.entity.Cart;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CartMapper {

    CartMapper INSTANCE = Mappers.getMapper(CartMapper.class);


    @Mapping(source = "user.id", target = "userId")
    CreateCartResponseDto createCartResponseDtoFromCart(Cart cart);
    GetCartResponseDto getCartResponseDtoFromCart(Cart cart);
    /*@Mapping(source = "user.id", target = "userId")*/
    List<ListCartResponseDto> listResponseDtoFromCart(List<Cart> carts);
    @Mapping(source = "userId", target = "user.id")
    Cart cartFromCreateRequestDto(CreateCartRequestDto dto);
    @Mapping(source = "userId", target = "user.id")

    Cart cartFromUpdateRequestDto(UpdateCartRequestDto dto);
    UpdateCartResponseDto updateResponseDtoFromCart(Cart dto);
}

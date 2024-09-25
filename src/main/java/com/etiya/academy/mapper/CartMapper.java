package com.etiya.academy.mapper;

import com.etiya.academy.dto.cart.*;
import com.etiya.academy.entity.Cart;
import org.mapstruct.factory.Mappers;

import java.util.List;

public interface CartMapper {

    CartMapper INSTANCE = Mappers.getMapper(CartMapper.class);

    CreateCartResponseDto createCartResponseDtoFromCart(Cart cart);
    GetCartResponseDto getCartResponseDtoFromCart(Cart cart);
    List<ListCartResponseDto> listResponseDtoFromCart(List<Cart> carts);
    Cart cartFromCreateRequestDto(CreateCartRequestDto dto);
    Cart cartFromUpdateRequestDto(UpdateCartRequestDto dto);
    UpdateCartResponseDto updateResponseDtoFromCart(Cart dto);
}

package com.etiya.academy.service;

import com.etiya.academy.core.exception.type.BusinessException;
import com.etiya.academy.dto.cart.CreateCartRequestDto;
import com.etiya.academy.dto.cart.CreateCartResponseDto;
import com.etiya.academy.dto.cart.ListCartResponseDto;
import com.etiya.academy.dto.cart.*;
import com.etiya.academy.entity.Cart;
import com.etiya.academy.entity.User;
import com.etiya.academy.mapper.CartMapper;
import com.etiya.academy.mapper.UserMapper;
import com.etiya.academy.repository.CartRepository;
import com.etiya.academy.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService{
    private final CartRepository cartRepository;
    @Override
    public List<ListCartResponseDto> getAll() {
        List<Cart> carts =  cartRepository.findAll();

        List<ListCartResponseDto> responseDtos = CartMapper.INSTANCE.listResponseDtoFromCart(carts);

        return responseDtos;
    }

    @Override
    public CreateCartResponseDto add(CreateCartRequestDto createCartRequestDto) {


        Cart cart = CartMapper.INSTANCE.cartFromCreateRequestDto(createCartRequestDto);
        cart.setCreatedDate(LocalDate.from(LocalDateTime.now()));

        // Cart -> add
        Cart addedCart = cartRepository.save(cart);
        // Cart -> Response
        CreateCartResponseDto createCartResponseDto = CartMapper.INSTANCE.createCartResponseDtoFromCart(addedCart);
        return createCartResponseDto;

    }

    @Override
    public GetCartResponseDto getById(int id) {
        Optional<Cart> cartOptional = cartRepository.findById(id);
        if (cartOptional.isPresent()) {
            Cart cart = cartOptional.get();
            GetCartResponseDto getCartByIdResponseDto = CartMapper.INSTANCE.getCartResponseDtoFromCart(cart);
            return getCartByIdResponseDto;
        } else {
            throw new BusinessException("Cart with id " + id + " not found");
        }
    }

    @Override
    public void delete(int id) {
        cartRepository.deleteById(id);
    }

    @Override
    public UpdateCartResponseDto update(int id, UpdateCartRequestDto updateCartRequestDto) {
        Optional<Cart> cartInDb  = cartRepository.findById(id);
        if (cartInDb.isPresent()) {

            if(cartInDb.get().getUser().getId() == updateCartRequestDto.getUserId()){
                throw new BusinessException("User id'ler eşit.");
            }
            // requestDto -> cart
            Cart cart1 = CartMapper.INSTANCE.cartFromUpdateRequestDto(updateCartRequestDto);
            cart1.setId(id);

            // cart update
            Cart updatedCart = cartRepository.save(cart1);

            // cart -> responseDto
            UpdateCartResponseDto responseCart = CartMapper.INSTANCE.updateResponseDtoFromCart(updatedCart);

            return responseCart;
        }
        else {
            throw new BusinessException("Cart with id " + id + " not found");
        }
    }
}

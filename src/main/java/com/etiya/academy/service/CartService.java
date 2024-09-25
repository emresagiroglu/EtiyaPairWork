package com.etiya.academy.service;

import com.etiya.academy.dto.cart.*;
import com.etiya.academy.dto.user.*;

import java.util.List;

public interface CartService {

    List<ListCartResponseDto> getAll();
    CreateCartResponseDto add(CreateCartRequestDto createCartRequestDto);
    GetCartResponseDto getById(int id);
    void delete(int id);
    UpdateCartResponseDto update(int id, UpdateCartRequestDto updateCartRequestDto);
}

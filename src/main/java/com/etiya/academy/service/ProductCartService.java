package com.etiya.academy.service;

import com.etiya.academy.dto.cart.*;
import com.etiya.academy.dto.productCart.*;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductCartService {


    List<ListProductCartResponseDto> getAll();
    CreateProductCartResponseDto add(CreateProductCartRequestDto createProductCartRequestDto);
    GetProductCartResponseDto getById(int id);
    void delete(int id);
    UpdateProductCartResponseDto update(int id, UpdateProductCartRequestDto updateProductCartRequestDto);
}

package com.etiya.academy.service;

import com.etiya.academy.dto.product.*;
import com.etiya.academy.entity.Product;
import java.util.List;

public interface ProductService {

    List<ListProductResponseDto> getAll();
    CreateProductResponseDto add(CreateProductRequestDto createProductRequestDto);
    GetProductByIdResponseDto getById(int id);
    void delete(int id);
    UpdateProductResponseDto update(int id, UpdateProductRequestDto product);
}

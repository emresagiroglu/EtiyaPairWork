package com.etiya.academy.service;

import com.etiya.academy.dto.category.*;
import com.etiya.academy.dto.product.*;

import java.util.List;

public interface CategoryService {
    List<ListCategoryResponseDto> getAll();
    CreateCategoryResponseDto add(CreateCategoryRequestDto createCategoryRequestDto);
    GetCategoryByIdResponseDto getById(int id);
    void delete(int id);
    UpdateCategoryResponseDto update(int id, UpdateCategoryRequestDto category);
}

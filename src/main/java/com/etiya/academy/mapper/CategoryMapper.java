package com.etiya.academy.mapper;

import com.etiya.academy.dto.category.*;
import com.etiya.academy.dto.product.*;
import com.etiya.academy.entity.Category;
import com.etiya.academy.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CreateCategoryResponseDto createCategoryResponseDtoFromCategory(Category category);
    GetCategoryByIdResponseDto getCategoryResponseDtoFromCategory(Category category);
    List<ListCategoryResponseDto> listResponseDtoFromCategory(List<Category> dto);
    Category categoryFromCreateRequestDto(CreateCategoryRequestDto dto);
    Category categoryFromUpdateRequestDto(UpdateCategoryRequestDto dto);
    UpdateCategoryResponseDto updateResponseDtoFromCategory(Category dto);
}

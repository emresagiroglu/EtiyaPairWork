package com.etiya.academy.service;

import com.etiya.academy.dto.category.*;
import com.etiya.academy.dto.product.CreateProductResponseDto;
import com.etiya.academy.dto.product.GetProductByIdResponseDto;
import com.etiya.academy.dto.product.ListProductResponseDto;
import com.etiya.academy.dto.product.UpdateProductResponseDto;
import com.etiya.academy.entity.Category;
import com.etiya.academy.entity.Product;
import com.etiya.academy.mapper.CategoryMapper;
import com.etiya.academy.mapper.ProductMapper;
import com.etiya.academy.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{
    private final CategoryRepository categoryRepository;

    @Override
    public List<ListCategoryResponseDto> getAll() {

        List<Category> categories =  categoryRepository.getAll();

        List<ListCategoryResponseDto> listCategoryResponseDtos = CategoryMapper.INSTANCE.listResponseDtoFromCategory(categories);
        return listCategoryResponseDtos;
    }

    @Override
    public CreateCategoryResponseDto add(CreateCategoryRequestDto createCategoryRequestDto) {
        Random random = new Random();

        Category category = CategoryMapper.INSTANCE.categoryFromCreateRequestDto(createCategoryRequestDto);
        category.setId(random.nextInt(1,99999));

        Category addedCategory = categoryRepository.add(category);

        CreateCategoryResponseDto createCategoryResponseDto = CategoryMapper.INSTANCE.createCategoryResponseDtoFromCategory(addedCategory);
        return createCategoryResponseDto;
    }

    @Override
    public GetCategoryByIdResponseDto getById(int id) {
        Category category = categoryRepository.getById(id);
        GetCategoryByIdResponseDto getCategoryByIdResponseDto = CategoryMapper.INSTANCE.getCategoryResponseDtoFromCategory(category);
        return getCategoryByIdResponseDto;
    }

    @Override
    public void delete(int id) {
        categoryRepository.delete(id);
    }

    @Override
    public UpdateCategoryResponseDto update(int id, UpdateCategoryRequestDto category) {

        Category category1 = CategoryMapper.INSTANCE.categoryFromUpdateRequestDto(category);
        category1.setId(id);

        Category updatedCategory = categoryRepository.update(category1);

        UpdateCategoryResponseDto responseCategory = CategoryMapper.INSTANCE.updateResponseDtoFromCategory(updatedCategory);

        return responseCategory;
    }
}

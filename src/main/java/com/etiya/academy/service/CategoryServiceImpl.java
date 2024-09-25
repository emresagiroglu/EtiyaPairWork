package com.etiya.academy.service;

import com.etiya.academy.core.exception.type.BusinessException;
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
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{
    private final CategoryRepository categoryRepository;

    @Override
    public List<ListCategoryResponseDto> getAll() {

        List<Category> categories =  categoryRepository.findAll();

        List<ListCategoryResponseDto> listCategoryResponseDtos = CategoryMapper.INSTANCE.listResponseDtoFromCategory(categories);
        return listCategoryResponseDtos;
    }

    @Override
    public CreateCategoryResponseDto add(CreateCategoryRequestDto createCategoryRequestDto) {
        boolean categoryWithSameName  = categoryRepository.findAll()
                .stream()
                .anyMatch(category -> category.getName().equals(createCategoryRequestDto.getName()));

        LocalTime now = LocalTime.now(); // Saat 17 mi kontrol et
         if (now.getHour() == 18)
         { throw new BusinessException("Bakımdayız! Lütfen daha sonra tekrar deneyin."); }

        if(categoryWithSameName){
            throw new BusinessException("Böyle bir kategori zaten var");
        }
        Random random = new Random();

        Category category = CategoryMapper.INSTANCE.categoryFromCreateRequestDto(createCategoryRequestDto);
        category.setId(random.nextInt(1,99999));

        Category addedCategory = categoryRepository.save(category);

        CreateCategoryResponseDto createCategoryResponseDto = CategoryMapper.INSTANCE.createCategoryResponseDtoFromCategory(addedCategory);
        return createCategoryResponseDto;
    }

    @Override
    public GetCategoryByIdResponseDto getById(int id) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);

        if (categoryOptional.isPresent()) {
            Category category = categoryOptional.get();
            GetCategoryByIdResponseDto getCategoryByIdResponseDto = CategoryMapper.INSTANCE.getCategoryResponseDtoFromCategory(category);
            return getCategoryByIdResponseDto;
        } else {
            throw new BusinessException("Category with id " + id + " not found");
        }
    }

    @Override
    public void delete(int id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public UpdateCategoryResponseDto update(int id, UpdateCategoryRequestDto category) {
        Optional<Category> categoryInDb  = categoryRepository.findById(id);
        if (categoryInDb.isPresent()) {

            if(categoryInDb.get().getName().equals(category.getName())){
                throw new BusinessException("Kategori ismi aynı.");
            }

            Category category1 = CategoryMapper.INSTANCE.categoryFromUpdateRequestDto(category);
            category1.setId(id);

            Category updatedCategory = categoryRepository.save(category1);

            UpdateCategoryResponseDto responseCategory = CategoryMapper.INSTANCE.updateResponseDtoFromCategory(updatedCategory);

            return responseCategory;
        } else {
            throw new BusinessException("Böyle bir id yok");
        }
    }
}
package com.etiya.academy.service;

import com.etiya.academy.core.exception.type.BusinessException;
import com.etiya.academy.dto.productCart.CreateProductCartResponseDto;
import com.etiya.academy.dto.category.GetCategoryByIdResponseDto;
import com.etiya.academy.dto.category.ListCategoryResponseDto;
import com.etiya.academy.dto.category.UpdateCategoryResponseDto;
import com.etiya.academy.dto.productCart.*;
import com.etiya.academy.entity.Category;
import com.etiya.academy.entity.ProductCart;
import com.etiya.academy.mapper.CategoryMapper;
import com.etiya.academy.mapper.ProductCartMapper;
import com.etiya.academy.repository.ProductCartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class ProductCartServiceImpl implements ProductCartService{
    private final ProductCartRepository productCartRepository;
    @Override
    public List<ListProductCartResponseDto> getAll() {

        List<ProductCart> productCarts =  productCartRepository.findAll();

        List<ListProductCartResponseDto> listProductCartResponseDtos = ProductCartMapper.INSTANCE.listResponseDtoFromProductCart(productCarts);
        return listProductCartResponseDtos;
    }

    @Override
    public GetProductCartResponseDto getById(int id) {
        Optional<ProductCart> productCartOptional = productCartRepository.findById(id);

        if (productCartOptional.isPresent()) {
            ProductCart productCart = productCartOptional.get();
            GetProductCartResponseDto getProductCartResponseDto = ProductCartMapper.INSTANCE.getProductCartResponseDtoFromProductCart(productCart);
            return getProductCartResponseDto;
        } else {
            throw new BusinessException("ProductCart with id " + id + " not found");
        }
    }

    @Override
    public CreateProductCartResponseDto add(CreateProductCartRequestDto createProductCartRequestDto) {
        ProductCart productCart = ProductCartMapper.INSTANCE.productCartFromCreateRequestDto(createProductCartRequestDto);
        ProductCart addedProductCart = productCartRepository.save(productCart);
        CreateProductCartResponseDto createProductCartResponseDto = ProductCartMapper.INSTANCE.createProductCartResponseDtoFromProductCart(addedProductCart);
        return createProductCartResponseDto;
    }

    @Override
    public void delete(int id) {
        productCartRepository.deleteById(id);
    }

    @Override
    public UpdateProductCartResponseDto update(int id, UpdateProductCartRequestDto updateProductCartRequestDto) {
        Optional<ProductCart> productCartInDb  = productCartRepository.findById(id);
        if (productCartInDb.isPresent()) {


            ProductCart productCart1 = ProductCartMapper.INSTANCE.productCartFromUpdateRequestDto(updateProductCartRequestDto);
            productCart1.setId(id);

            ProductCart updatedProductCart = productCartRepository.save(productCart1);

            UpdateProductCartResponseDto responseProductCart = ProductCartMapper.INSTANCE.updateResponseDtoFromProductCart(updatedProductCart);

            return responseProductCart;
        } else {
            throw new BusinessException("Böyle bir id yok");
    }
    }
}

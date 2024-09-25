package com.etiya.academy.service;

import com.etiya.academy.core.exception.type.BusinessException;
import com.etiya.academy.dto.product.*;
import com.etiya.academy.entity.Product;
import com.etiya.academy.mapper.ProductMapper;
import com.etiya.academy.repository.CategoryRepository;
import com.etiya.academy.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryService categoryService;

    @Override
    public List<ListProductResponseDto> getAll() {

        // Business Logic -> Loglama, Auth, İş kuralları, Validasyon

        List<Product> products =  productRepository.findAll();


        List<ListProductResponseDto> responseDtos = ProductMapper.INSTANCE.listResponseDtoFromProduct(products);
//
        return responseDtos;
    }

    @Override
    public GetProductByIdResponseDto getById(int id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            GetProductByIdResponseDto getProductByIdResponseDto = ProductMapper.INSTANCE.getProductResponseDtoFromProduct(product);
            return getProductByIdResponseDto;
        } else {
            throw new BusinessException("Product with id " + id + " not found");
        }
    }

    @Override
    public CreateProductResponseDto add(CreateProductRequestDto createProductRequestDto) {

        boolean productWithSameName  = productRepository.findAll().stream().anyMatch(product -> product.getName().equals(createProductRequestDto.getName()));
        if (productWithSameName) {
            throw new BusinessException("Böyle bir ürün zaten var");
        }
        boolean isCategoryIdExist = categoryService.getAll().stream().anyMatch(category -> category.getId() == createProductRequestDto.getCategoryId());
        if(!isCategoryIdExist){
            throw new BusinessException("Böyle bir Kategori id yok");
        }
        //request -> Product
        Product product = ProductMapper.INSTANCE.productFromCreateRequestDto(createProductRequestDto);
        // Product -> add
        Product addedProduct = productRepository.save(product);
        // Product -> Response
        CreateProductResponseDto createProductResponseDto = ProductMapper.INSTANCE.createProductResponseDtoFromProduct(addedProduct);
        return createProductResponseDto;

    }

    @Override
    public void delete(int id) {
        productRepository.deleteById(id);
    }

    @Override
    public UpdateProductResponseDto update(int id,UpdateProductRequestDto product) {
        Optional<Product> productInDb  = productRepository.findById(id);
        if(productInDb.get().getName().equals(product.getName()) && productInDb.get().getUnitPrice()  == product.getUnitPrice() && productInDb.get().getUnitsInStock() == product.getUnitsInStock()){
            throw new BusinessException("Ürün fieldları aynı");
        }
        // requestDto -> product
        Product product1 = ProductMapper.INSTANCE.productFromUpdateRequestDto(product);
        product1.setId(id);

        // product update
        Product updatedProduct = productRepository.save(product1);

        // product -> responseDto
        UpdateProductResponseDto responseProduct = ProductMapper.INSTANCE.updateResponseDtoFromProduct(updatedProduct);

        return responseProduct;
    }

}


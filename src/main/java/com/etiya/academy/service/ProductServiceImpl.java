package com.etiya.academy.service;

import com.etiya.academy.dto.product.*;
import com.etiya.academy.entity.Product;
import com.etiya.academy.mapper.ProductMapper;
import com.etiya.academy.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public List<ListProductResponseDto> getAll() {

        // Business Logic -> Loglama, Auth, İş kuralları, Validasyon

        List<Product> products =  productRepository.getAll();

        List<ListProductResponseDto> listProductResponseDtos = ProductMapper.INSTANCE.listResponseDtoFromProduct(products);
        return listProductResponseDtos;
    }

    @Override
    public GetProductByIdResponseDto getById(int id) {
        Product product = productRepository.getById(id);
        GetProductByIdResponseDto getProductByIdResponseDto = ProductMapper.INSTANCE.getProductResponseDtoFromProduct(product);
        return getProductByIdResponseDto;
    }

    @Override
    public CreateProductResponseDto add(CreateProductRequestDto createProductRequestDto) {
        //request -> Product
        Random random = new Random();

        Product product = ProductMapper.INSTANCE.productFromCreateRequestDto(createProductRequestDto);
        product.setId(random.nextInt(1,99999));
        // Product -> add
        Product addedProduct = productRepository.add(product);
        // Product -> Response
        CreateProductResponseDto createProductResponseDto = ProductMapper.INSTANCE.createProductResponseDtoFromProduct(addedProduct);
        return createProductResponseDto;

    }

    @Override
    public void delete(int id) {
        productRepository.delete(id);
    }

    @Override
    public UpdateProductResponseDto update(int id,UpdateProductRequestDto product) {

        // requestDto -> product
        Product product1 = ProductMapper.INSTANCE.productFromUpdateRequestDto(product);
        product1.setId(id);

        // product update
        Product updatedProduct = productRepository.update(product1);

        // product -> responseDto
        UpdateProductResponseDto responseProduct = ProductMapper.INSTANCE.updateResponseDtoFromProduct(updatedProduct);

        return responseProduct;
    }

}


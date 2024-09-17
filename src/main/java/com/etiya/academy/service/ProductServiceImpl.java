package com.etiya.academy.service;

import com.etiya.academy.entity.Product;
import com.etiya.academy.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public List<Product> getAll() {
        // Business Logic -> Loglama, Auth, İş kuralları, Validasyon
        return productRepository.getAll();
    }

    @Override
    public void add(Product product) {
        for(Product product1 : getAll()){
            if(product1.getId() == product.getId()){
                throw new RuntimeException("Aynı ID olamaz");
            }
        }
        productRepository.add(product);

    }


    @Override
    public Product getById(int id) {
        return productRepository.getById(id);
    }

    @Override
    public void delete(int id) {
        productRepository.delete(id);
    }

    @Override
    public Product update(Product product) {
        return productRepository.update(product);
    }

}


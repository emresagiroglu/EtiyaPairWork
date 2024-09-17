package com.etiya.academy.service;

import com.etiya.academy.entity.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> getAll();
    void add(Product product);
    Product getById(int id);

    void delete(int id);
    Product update(Product product);
}

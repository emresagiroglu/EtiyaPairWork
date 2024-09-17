package com.etiya.academy.service;

import com.etiya.academy.entity.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> getAll();
    void add(Product product);
    Optional<Product> getById(int id);

    boolean delete(int id);
    boolean update(int id, Product product);
}

package com.etiya.academy.repository;

import com.etiya.academy.entity.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductRepository {
    List<Product> getAll();
    void add(Product product);
    Product getById(int id);

    boolean delete(int id);
    boolean update(int id , Product product);

}

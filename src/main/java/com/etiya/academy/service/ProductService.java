package com.etiya.academy.service;

import com.etiya.academy.entity.Product;
import java.util.List;

public interface ProductService {

    List<Product> getAll();
    void add(Product product);
    Product getById(int id);
    void delete(int id);
    Product update(Product product);
}

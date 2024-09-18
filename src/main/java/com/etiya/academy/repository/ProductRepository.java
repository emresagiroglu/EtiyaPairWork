package com.etiya.academy.repository;

import com.etiya.academy.entity.Product;
import java.util.List;

public interface ProductRepository {
    List<Product> getAll();
    Product add(Product product);
    Product getById(int id);
    void delete(int id);
    Product update(Product product);

}

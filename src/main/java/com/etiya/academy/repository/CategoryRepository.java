package com.etiya.academy.repository;

import com.etiya.academy.entity.Category;
import com.etiya.academy.entity.Product;

import java.util.List;

public interface CategoryRepository {
    List<Category> getAll();
    Category add(Category category);
    Category getById(int id);
    void delete(int id);
    Category update(Category category);
}

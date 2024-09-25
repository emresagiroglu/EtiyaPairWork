package com.etiya.academy.repository;

import com.etiya.academy.entity.Category;
import com.etiya.academy.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}

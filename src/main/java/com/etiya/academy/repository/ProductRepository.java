package com.etiya.academy.repository;

import com.etiya.academy.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Integer> {

    //Product findById(int id);
}

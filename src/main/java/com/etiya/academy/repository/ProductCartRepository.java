package com.etiya.academy.repository;

import com.etiya.academy.entity.ProductCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCartRepository extends JpaRepository<ProductCart,Integer> {
}

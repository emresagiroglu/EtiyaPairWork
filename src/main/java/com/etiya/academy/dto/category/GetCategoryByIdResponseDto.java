package com.etiya.academy.dto.category;

import com.etiya.academy.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCategoryByIdResponseDto {
    private String name;
    private List<Product> products;
}

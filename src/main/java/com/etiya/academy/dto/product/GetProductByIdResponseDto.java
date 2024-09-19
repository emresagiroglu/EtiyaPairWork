package com.etiya.academy.dto.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetProductByIdResponseDto {
    private String name;
    private double unitPrice;
    private int unitsInStock;
    private int categoryId;
}

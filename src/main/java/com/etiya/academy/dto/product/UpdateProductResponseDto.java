package com.etiya.academy.dto.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProductResponseDto {
    private String name;
    private BigDecimal unitPrice;
    private int unitsInStock;
    private int categoryId;
}

package com.etiya.academy.dto.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListProductResponseDto {
    private int id;
    private String name;
    private BigDecimal unitPrice;
    private int categoryId;
}

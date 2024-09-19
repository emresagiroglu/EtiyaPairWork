package com.etiya.academy.dto.product;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProductRequestDto {
    @NotNull
    @NotBlank
    @Size(min = 2, max = 10,message = "Product name's length should be between 2-10 characters.")
    private String name;

    @Positive
    @Min(40)
    private double unitPrice;

    @Positive
    private int unitsInStock;

    @NotBlank
    private int categoryId;
}

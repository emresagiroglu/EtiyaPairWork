package com.etiya.academy.dto.product;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductRequestDto {
    @NotNull
    @NotBlank
    @Size(min = 2, max = 10)
    private String name;

    @Positive
    @Min(40)
    private double unitPrice;

    @PositiveOrZero
    private int unitsInStock;

    @NotBlank
    private int categoryId;
}

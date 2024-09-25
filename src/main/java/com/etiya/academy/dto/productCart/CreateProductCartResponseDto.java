package com.etiya.academy.dto.productCart;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductCartResponseDto {


    private int cartId;

    private int productId;


    private int quantity;
}

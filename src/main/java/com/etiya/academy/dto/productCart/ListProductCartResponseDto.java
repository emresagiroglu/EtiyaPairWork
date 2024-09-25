package com.etiya.academy.dto.productCart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListProductCartResponseDto {
    private int cartId;
    private int productId;
    private int quantity;


}

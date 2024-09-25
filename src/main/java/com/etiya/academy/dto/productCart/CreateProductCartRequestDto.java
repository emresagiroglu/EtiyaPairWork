package com.etiya.academy.dto.productCart;

import com.etiya.academy.entity.Cart;
import com.etiya.academy.entity.Product;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductCartRequestDto {

    @NotBlank
    private int cartId;

    @NotBlank
    private int productId;

    @NotBlank
    private int quantity;
}

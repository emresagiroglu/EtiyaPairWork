package com.etiya.academy.dto.cart;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCartRequestDto {

    private LocalDate createdDate;

    @NotNull
    private int userId;
}

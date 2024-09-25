package com.etiya.academy.dto.cart;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCartResponseDto {

    private int id;
    private LocalDate createdDate;
    private int userId;
}

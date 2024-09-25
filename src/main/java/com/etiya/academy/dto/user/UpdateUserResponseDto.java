package com.etiya.academy.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserResponseDto {

    private String identityNo;
    private String name;
    private String surname;
}

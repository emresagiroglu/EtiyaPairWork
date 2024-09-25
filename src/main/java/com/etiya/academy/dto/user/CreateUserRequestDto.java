package com.etiya.academy.dto.user;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserRequestDto {
    @NotNull
    @NotBlank
    @Size(min = 11, max = 11)
    private String identityNo;

    @NotNull
    @NotBlank
    @Size(min = 3)
    private String name;

    @NotNull
    @NotBlank
    private String surname;
}

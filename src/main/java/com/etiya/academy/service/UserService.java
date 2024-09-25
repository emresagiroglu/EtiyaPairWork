package com.etiya.academy.service;

import com.etiya.academy.dto.category.*;
import com.etiya.academy.dto.user.*;

import java.util.List;

public interface UserService {

    List<ListUserResponseDto> getAll();
    CreateUserResponseDto add(CreateUserRequestDto createUserRequestDto);
    GetUserByIdResponseDto getById(int id);
    void delete(int id);
    UpdateUserResponseDto update(int id, UpdateUserRequestDto updateUserRequestDto);
}

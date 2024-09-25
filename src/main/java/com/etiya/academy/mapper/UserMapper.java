package com.etiya.academy.mapper;

import com.etiya.academy.dto.user.*;
import com.etiya.academy.entity.Cart;
import com.etiya.academy.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    CreateUserResponseDto createUserResponseDtoFromUser(User user);
    GetUserByIdResponseDto getUserResponseDtoFromUser(User user);
    List<ListUserResponseDto> listResponseDtoFromUser(List<User> users);
    User userFromCreateRequestDto(CreateUserRequestDto dto);
    User userFromUpdateRequestDto(UpdateUserRequestDto dto);
    UpdateUserResponseDto updateResponseDtoFromUser(User dto);
}

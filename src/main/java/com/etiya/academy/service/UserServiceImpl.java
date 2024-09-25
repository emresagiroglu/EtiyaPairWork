package com.etiya.academy.service;

import com.etiya.academy.core.exception.type.BusinessException;
import com.etiya.academy.dto.user.CreateUserResponseDto;
import com.etiya.academy.dto.product.ListProductResponseDto;
import com.etiya.academy.dto.product.UpdateProductResponseDto;
import com.etiya.academy.dto.user.*;
import com.etiya.academy.entity.Product;
import com.etiya.academy.entity.User;
import com.etiya.academy.mapper.ProductMapper;
import com.etiya.academy.mapper.UserMapper;
import com.etiya.academy.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    @Override
    public List<ListUserResponseDto> getAll() {
        List<User> users =  userRepository.findAll();


        List<ListUserResponseDto> responseDtos = UserMapper.INSTANCE.listResponseDtoFromUser(users);

        return responseDtos;
    }

    @Override
    public CreateUserResponseDto add(CreateUserRequestDto createUserRequestDto) {
        boolean userWithSameId  = userRepository.findAll().stream().anyMatch(user -> user.getIdentityNo().equals(createUserRequestDto.getIdentityNo()));
        if (userWithSameId) {
            throw new BusinessException("Böyle bir kullanıcı var.'");
        }

        User user = UserMapper.INSTANCE.userFromCreateRequestDto(createUserRequestDto);
        // User -> add
        User addedUser = userRepository.save(user);
        // User -> Response
        CreateUserResponseDto createUserResponseDto = UserMapper.INSTANCE.createUserResponseDtoFromUser(addedUser);
        return createUserResponseDto;

    }

    @Override
    public GetUserByIdResponseDto getById(int id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            GetUserByIdResponseDto getUserByIdResponseDto = UserMapper.INSTANCE.getUserResponseDtoFromUser(user);
            return getUserByIdResponseDto;
        } else {
            throw new BusinessException("User with id " + id + " not found");
        }
    }

    @Override
    public void delete(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public UpdateUserResponseDto update(int id, UpdateUserRequestDto updateUserRequestDto) {
        Optional<User> userInDb  = userRepository.findById(id);
        if (userInDb.isPresent()) {

            if(userInDb.get().getName().equals(updateUserRequestDto.getName()) && userInDb.get().getSurname().equals(updateUserRequestDto.getSurname()) && userInDb.get().getIdentityNo().equals(updateUserRequestDto.getIdentityNo())){
                throw new BusinessException("Ürün fieldları aynı");
            }
            // requestDto -> user
            User user1 = UserMapper.INSTANCE.userFromUpdateRequestDto(updateUserRequestDto);
            user1.setId(id);

            // user update
            User updatedUser = userRepository.save(user1);

            // user -> responseDto
            UpdateUserResponseDto responseUser = UserMapper.INSTANCE.updateResponseDtoFromUser(updatedUser);

            return responseUser;
        }
        else {
            throw new BusinessException("User with id " + id + " not found");
        }
    }
}


package com.etiya.academy.controller;

import com.etiya.academy.dto.user.*;
import com.etiya.academy.dto.user.ListUserResponseDto;
import com.etiya.academy.service.UserService;
import com.etiya.academy.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping()
    public List<ListUserResponseDto> getAll(){
        return userService.getAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<GetUserByIdResponseDto> getById(@PathVariable int id){
        GetUserByIdResponseDto user = userService.getById(id);
        if(user != null){
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PostMapping()
    public ResponseEntity<CreateUserResponseDto> add(@RequestBody CreateUserRequestDto createUserRequestDto){
        return new ResponseEntity<>(userService.add(createUserRequestDto),HttpStatus.CREATED) ;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        GetUserByIdResponseDto user = userService.getById(id);
        if (user != null) {
            userService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);// Status 200
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Status 404
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateUserResponseDto> update(@PathVariable int id, @RequestBody UpdateUserRequestDto updatedUser) {
        GetUserByIdResponseDto user = userService.getById(id);
        if(user != null){
            UpdateUserResponseDto updateUserResponseDto = userService.update(id,updatedUser);
            return new ResponseEntity<>(updateUserResponseDto,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}


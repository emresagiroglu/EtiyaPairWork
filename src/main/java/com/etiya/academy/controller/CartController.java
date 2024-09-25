package com.etiya.academy.controller;

import com.etiya.academy.dto.cart.ListCartResponseDto;
import com.etiya.academy.dto.cart.*;
import com.etiya.academy.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(value = "/api/v1/carts")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @GetMapping()
    public List<ListCartResponseDto> getAll(){
        return cartService.getAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<GetCartResponseDto> getById(@PathVariable int id){
        GetCartResponseDto cart = cartService.getById(id);
        if(cart != null){
            return new ResponseEntity<>(cart, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PostMapping()
    public ResponseEntity<CreateCartResponseDto> add(@RequestBody CreateCartRequestDto createCartRequestDto){
        return new ResponseEntity<>(cartService.add(createCartRequestDto),HttpStatus.CREATED) ;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        GetCartResponseDto cart = cartService.getById(id);
        if (cart != null) {
            cartService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);// Status 200
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Status 404
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateCartResponseDto> update(@PathVariable int id, @RequestBody UpdateCartRequestDto updatedCart) {
        GetCartResponseDto cart = cartService.getById(id);
        if(cart != null){
            UpdateCartResponseDto updateCartResponseDto = cartService.update(id,updatedCart);
            return new ResponseEntity<>(updateCartResponseDto,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

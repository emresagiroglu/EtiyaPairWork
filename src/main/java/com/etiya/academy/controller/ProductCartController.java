package com.etiya.academy.controller;

import com.etiya.academy.dto.productCart.*;
import com.etiya.academy.service.ProductCartService;
import com.etiya.academy.service.ProductCartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/product-carts")
@RequiredArgsConstructor
public class ProductCartController {
    private final ProductCartService productCartService;

    @GetMapping()
    public List<ListProductCartResponseDto> getAll(){
        return productCartService.getAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<GetProductCartResponseDto> getById(@PathVariable int id){
        GetProductCartResponseDto productCarts = productCartService.getById(id);
        if(productCarts != null){
            return new ResponseEntity<>(productCarts, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PostMapping()
    public ResponseEntity<CreateProductCartResponseDto> add(@RequestBody CreateProductCartRequestDto createProductCartRequestDto){
        return new ResponseEntity<>(productCartService.add(createProductCartRequestDto),HttpStatus.CREATED) ;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        GetProductCartResponseDto productCarts = productCartService.getById(id);
        if (productCarts != null) {
            productCartService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);// Status 200
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Status 404
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateProductCartResponseDto> update(@PathVariable int id, @RequestBody UpdateProductCartRequestDto updatedProductCart) {
        GetProductCartResponseDto productCarts = productCartService.getById(id);
        if(productCarts != null){
            UpdateProductCartResponseDto updateProductCartResponseDto = productCartService.update(id,updatedProductCart);
            return new ResponseEntity<>(updateProductCartResponseDto,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

package com.etiya.academy.controller;

import com.etiya.academy.dto.category.*;
import com.etiya.academy.dto.product.*;
import com.etiya.academy.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping()
    public List<ListCategoryResponseDto> getAll(){
        return categoryService.getAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<GetCategoryByIdResponseDto> getById(@PathVariable int id){
        GetCategoryByIdResponseDto category = categoryService.getById(id);
        if(category != null){
            return new ResponseEntity<>(category, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PostMapping()
    public ResponseEntity<CreateCategoryResponseDto> add(@RequestBody CreateCategoryRequestDto createCategoryRequestDto){
        return new ResponseEntity<>(categoryService.add(createCategoryRequestDto),HttpStatus.CREATED) ;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        GetCategoryByIdResponseDto category = categoryService.getById(id);
        if (category != null) {
            categoryService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);// Status 200
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Status 404
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateCategoryResponseDto> update(@PathVariable int id, @RequestBody UpdateCategoryRequestDto updatedCategory) {
        GetCategoryByIdResponseDto category = categoryService.getById(id);
        if(category != null){
            UpdateCategoryResponseDto updateCategoryResponseDto = categoryService.update(id,updatedCategory);
            return new ResponseEntity<>(updateCategoryResponseDto,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}

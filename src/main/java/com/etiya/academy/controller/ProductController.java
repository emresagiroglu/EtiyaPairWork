package com.etiya.academy.controller;


import com.etiya.academy.dto.product.*;
import com.etiya.academy.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/product")
@RequiredArgsConstructor // final olarak işaretlenen tüm arg.ları içeren constructor
public class ProductController {

    private final ProductService productService;

    // 5 temel operation
    @GetMapping()
    public List<ListProductResponseDto> getAll(){
        return productService.getAll();
    }

    //getById methodu güncellendi.
    @GetMapping("/{id}")
    public ResponseEntity<GetProductByIdResponseDto> getById(@PathVariable int id){
        GetProductByIdResponseDto product = productService.getById(id);
        if(product != null){
            return new ResponseEntity<>(product,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping()
    public ResponseEntity<CreateProductResponseDto> add(@RequestBody CreateProductRequestDto createProductRequestDto){
       return new ResponseEntity<>(productService.add(createProductRequestDto),HttpStatus.CREATED) ;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
       GetProductByIdResponseDto product = productService.getById(id);
        if (product != null) {
            productService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);// Status 200
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Status 404
    }
    @PutMapping("/{id}")
    public ResponseEntity<UpdateProductResponseDto> update(@PathVariable int id, @RequestBody UpdateProductRequestDto updatedProduct) {
        GetProductByIdResponseDto product = productService.getById(id);
        if(product != null){
            UpdateProductResponseDto updateProductResponseDto = productService.update(id,updatedProduct);
            return new ResponseEntity<>(updateProductResponseDto,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

// Product controllerdaki 5 temel operasyonu kodlamak

// update->200 -- Ok
// delete->200 -- Ok
// add - eğer başarılı ise status code 201 dönsün -- Ok
// getbyid(id)->eğer id ile bir veriye rastlanmaz ise, status code 404 olsun. --Ok
// getall->200 -- Ok

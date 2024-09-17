package com.etiya.academy.controller;


import com.etiya.academy.entity.Product;
import com.etiya.academy.exception.NotFoundException;
import com.etiya.academy.service.ProductService;
import com.etiya.academy.service.ProductServiceImpl;
import lombok.AllArgsConstructor;
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
    public List<Product> getAll(){
        return productService.getAll();
    }
    @GetMapping("/{id}")
    public Product getById(@PathVariable int id){
        return productService.getById(id).orElseThrow(() -> new NotFoundException("Product not found with id: " + id));

    }
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody Product product){
        productService.add(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
       boolean isDeleted = productService.delete(id);
        if (isDeleted) {
            return ResponseEntity.ok().build(); // Status 200
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Status 404
    }
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable int id, @RequestBody Product updatedProduct) {
        boolean isUpdated = productService.update(id, updatedProduct);
        if (isUpdated) {
            return ResponseEntity.ok().build(); // Status 200
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Status 404
    }

}

// Product controllerdaki 5 temel operasyonu kodlamak

// update->200 -- Ok
// delete->200 -- Ok
// add - eğer başarılı ise status code 201 dönsün -- Ok
// getbyid(id)->eğer id ile bir veriye rastlanmaz ise, status code 404 olsun. --Ok
// getall->200 -- Ok

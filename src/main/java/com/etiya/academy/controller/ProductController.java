package com.etiya.academy.controller;


import com.etiya.academy.entity.Product;
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
    public List<Product> getAll(){
        return productService.getAll();
    }

    //getById methodu güncellendi.
    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable int id){
        Product product = productService.getById(id);
        if(product != null){
            return new ResponseEntity<>(product,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody Product product){
        productService.add(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> delete(@PathVariable int id) {
       Product product = productService.getById(id);
        if (product != null) {
            productService.delete(id);
            return new ResponseEntity<>(product,HttpStatus.OK);// Status 200
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Status 404
    }
    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable int id, @RequestBody Product updatedProduct) {
        Product product = productService.getById(id);
        if(product != null){
            productService.update(updatedProduct);
            return new ResponseEntity<>(product,HttpStatus.OK);
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

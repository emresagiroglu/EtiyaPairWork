package com.etiya.academy.repository;

import com.etiya.academy.entity.Product;
import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryProductRepository implements ProductRepository{

    List<Product> products = new ArrayList<>();
    @Override
    public List<Product> getAll() {
        return products;
    }
    public void add(Product product){
        products.add(product);
    }

    @Override
    public Product getById(int id) {
       for(Product product : products){
           if(product.getId() == id){
               return product;
           }
       }
       return null;
    }

    @Override
    public boolean delete(int id) {

        for(Product product :products){
            if(product.getId() == id) {
                products.remove(product);
                return true;
            }
        }
        return false;

    }

    @Override
    public boolean update(int id, Product product) {
        for(Product currentProduct: products){
            if(currentProduct.getId() == id){
                currentProduct.setName(product.getName());
                currentProduct.setUnitPrice(product.getUnitPrice());
                currentProduct.setUnitsInStock(product.getUnitsInStock());
                return true;
            }
        }
        return false;
    }

}

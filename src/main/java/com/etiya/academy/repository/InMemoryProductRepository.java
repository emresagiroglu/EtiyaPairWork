package com.etiya.academy.repository;

import com.etiya.academy.entity.Product;
import org.springframework.stereotype.Repository;
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
    public void delete(int id) {
       products.remove(getById(id));
    }

    @Override
    public Product update(Product product) {
        for(Product currentProduct: products){
            if(currentProduct.getId() == product.getId()){
                currentProduct.setName(product.getName());
                currentProduct.setUnitPrice(product.getUnitPrice());
                currentProduct.setUnitsInStock(product.getUnitsInStock());
                return currentProduct;
            }
        }
        return null;
    }

}

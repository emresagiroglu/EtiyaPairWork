package com.etiya.academy.service;

import com.etiya.academy.entity.Product;
import com.etiya.academy.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public List<Product> getAll() {
        // Business Logic -> Loglama, Auth, İş kuralları, Validasyon
        return productRepository.getAll();
    }

    @Override
    public void add(Product product) {
        // validasyon -> direkt verinin üzerinde farklı veri gerektirmeden yapılabilen kontrollerdir.
        // iş kuralı -> genelde diğer verilerle karşılaştırma üzerine yapılan bir yapıdır.

        // eposta adresi @ işareti içermelidir -> VALİDASYON
        // aynı e posta ile bir üye bulunmamalıdır -> iş kuralı

        // iş kuralı
        if(product.getName().length() < 3){
            throw new RuntimeException("Ürün ismi 3 haneden kısa olamaz.");
        }
        productRepository.add(product);
    }

    @Override
    public Optional<Product> getById(int id) {
        return Optional.ofNullable(productRepository.getById(id));
    }

    @Override
    public boolean delete(int id) {
        return productRepository.delete(id);
    }

    @Override
    public boolean update(int id, Product product) {
        return productRepository.update(id,product);
    }

}


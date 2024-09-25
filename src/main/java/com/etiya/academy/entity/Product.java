package com.etiya.academy.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="products")
public class Product
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private BigDecimal unitPrice;

    @Column(name = "stock")
    private int unitsInStock;

    @JoinColumn(name = "categoryid")
    @ManyToOne
    private Category category;

    @OneToMany(mappedBy = "product")
    private List<ProductCart> productCarts;
}

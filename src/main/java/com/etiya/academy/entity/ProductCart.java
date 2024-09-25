package com.etiya.academy.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product_carts")
public class ProductCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @JoinColumn(name = "cart_id")
    @ManyToOne
    private Cart cart;


    @JoinColumn(name = "product_id")
    @ManyToOne
    private Product product;

    @Column(name = "quantity")
    private int quantity;
}



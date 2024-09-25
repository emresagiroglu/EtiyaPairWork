package com.etiya.academy.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "carts")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "created_date")
    private LocalDate createdDate;

    @JoinColumn(name = "user_id")
    @OneToOne()
    private User user;

    @OneToMany(mappedBy = "cart")
    private List<ProductCart> productCarts;
}

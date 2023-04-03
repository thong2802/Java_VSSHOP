package com.ecommerce.ecommerce.model;

import jakarta.persistence.*;

@Entity
@Table(name = "product_option")
public class ProductOption {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(name = "name")
    private String name;
}

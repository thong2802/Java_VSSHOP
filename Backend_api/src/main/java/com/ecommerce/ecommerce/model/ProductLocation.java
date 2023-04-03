package com.ecommerce.ecommerce.model;

import jakarta.persistence.*;

@Entity
@Table(name = "product_location")
public class ProductLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long product_location_id;

    @OneToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "address")
    private String address;
}

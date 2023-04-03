package com.ecommerce.ecommerce.model;

import jakarta.persistence.*;

@Entity
@Table(name = "product_file")
public class ProductFile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long product_file_id;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(name = "type")
    private String type;

    @Column(name = "url")
    private String url;
}

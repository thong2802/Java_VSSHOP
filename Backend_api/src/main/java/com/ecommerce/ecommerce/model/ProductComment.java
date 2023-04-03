package com.ecommerce.ecommerce.model;

import jakarta.persistence.*;


@Entity
@Table(name = "product_comment")
public class ProductComment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long product_comment_id;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "content")
    private String content;
}

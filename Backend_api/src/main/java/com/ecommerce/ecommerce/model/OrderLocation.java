package com.ecommerce.ecommerce.model;

import jakarta.persistence.*;

@Entity
@Table(name = "order_location")
public class OrderLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long order_location_id;

    @OneToOne
    @JoinColumn(name = "order_id", nullable = true)
    private Order order;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "address")
    private String address;

    public long getOrder_location_id() {
        return order_location_id;
    }

    public void setOrder_location_id(long order_location_id) {
        this.order_location_id = order_location_id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

package com.ecommerce.ecommerce.payload.request;

import jakarta.validation.constraints.NotNull;

public class AddCartRequest {
    private @NotNull String productId;
    private @NotNull Integer quantity;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}

package com.ecommerce.ecommerce.payload.request;

import jakarta.validation.constraints.NotNull;

public class EditAccount {
    @NotNull(message = "username is not empty")
    private String username;

    @NotNull(message = "email is not empty")
    private String email;

    @NotNull(message = "phone is not empty")
    private String phone;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

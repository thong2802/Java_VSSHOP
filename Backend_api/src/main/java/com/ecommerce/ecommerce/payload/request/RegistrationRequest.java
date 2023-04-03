package com.ecommerce.ecommerce.payload.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

public class RegistrationRequest {
    @Valid
    @NotEmpty(message = "username is not empty!")
    private String name;
    @Valid
    @NotEmpty(message = "number phone is not empty")
    private String phone;
    @Email
    @Valid
    @NotEmpty(message = "email is not empty")
    private String email;
    @Valid
    @NotEmpty(message = "password is not empty")
    private String password;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

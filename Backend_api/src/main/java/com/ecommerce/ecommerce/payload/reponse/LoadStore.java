package com.ecommerce.ecommerce.payload.reponse;

public class LoadStore {
    private long id;
    private String logo;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String message;

    public LoadStore(long id, String logo, String name, String email, String phone, String address, String message) {
        this.id = id;
        this.logo = logo;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

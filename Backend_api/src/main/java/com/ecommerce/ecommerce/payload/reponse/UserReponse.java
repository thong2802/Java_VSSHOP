package com.ecommerce.ecommerce.payload.reponse;

public class UserReponse {
    private Long id;
    private String username;
    private String email;
    private String avatar;
    private String phone;

    public UserReponse(Long id, String username, String email, String avatar, String phone) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.avatar = avatar;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

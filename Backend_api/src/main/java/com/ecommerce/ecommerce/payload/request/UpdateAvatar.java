package com.ecommerce.ecommerce.payload.request;

import jakarta.validation.constraints.NotNull;

public class UpdateAvatar {
    @NotNull(message = "avatar is not empty")
    private String avatar;

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}

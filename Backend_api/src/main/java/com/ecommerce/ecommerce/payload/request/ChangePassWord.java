package com.ecommerce.ecommerce.payload.request;

import jakarta.validation.constraints.NotNull;

public class ChangePassWord {
    @NotNull(message = "OldPassword is not empty")
    private String OldPassword;

    @NotNull(message = "NewPassword is not empty")
    private String NewPassword;

    public String getOldPassword() {
        return OldPassword;
    }

    public void setOldPassword(String oldPassword) {
        OldPassword = oldPassword;
    }

    public String getNewPassword() {
        return NewPassword;
    }

    public void setNewPassword(String newPassword) {
        NewPassword = newPassword;
    }
}

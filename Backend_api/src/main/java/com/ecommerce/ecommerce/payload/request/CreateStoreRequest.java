package com.ecommerce.ecommerce.payload.request;

public class CreateStoreRequest {
    private String accountId;
    private String storeLogo;
    private String storeName;
    private String storePhone;
    private String storeEmail;
    private String storeAddress;

    public CreateStoreRequest(String accountId, String storeLogo, String storeName, String storePhone, String storeEmail, String storeAddress) {
        this.accountId = accountId;
        this.storeLogo = storeLogo;
        this.storeName = storeName;
        this.storePhone = storePhone;
        this.storeEmail = storeEmail;
        this.storeAddress = storeAddress;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getStoreLogo() {
        return storeLogo;
    }

    public void setStoreLogo(String storeLogo) {
        this.storeLogo = storeLogo;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStorePhone() {
        return storePhone;
    }

    public void setStorePhone(String storePhone) {
        this.storePhone = storePhone;
    }

    public String getStoreEmail() {
        return storeEmail;
    }

    public void setStoreEmail(String storeEmail) {
        this.storeEmail = storeEmail;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }
}

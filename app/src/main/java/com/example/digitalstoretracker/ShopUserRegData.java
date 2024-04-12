package com.example.digitalstoretracker;

public class ShopUserRegData {
    private String name,email,password,confirm_pass,mobileNum;

    public ShopUserRegData(String name, String email, String password, String confirm_pass, String mobileNum) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.confirm_pass = confirm_pass;
        this.mobileNum = mobileNum;
    }

    public ShopUserRegData() {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirm_pass() {
        return confirm_pass;
    }

    public void setConfirm_pass(String confirm_pass) {
        this.confirm_pass = confirm_pass;
    }

    public String getMobileNum() {
        return mobileNum;
    }

    public void setMobileNum(String mobileNum) {
        this.mobileNum = mobileNum;
    }
}

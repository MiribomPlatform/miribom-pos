package com.spirit.cloudpos.data;

public class RegisterData {
    private String userId;
    private String userName;
    private String mobile;
    private String email;

    public RegisterData(String userId, String userName, String mobile, String email) {
        this.userId = userId;
        this.userName = userName;
        this.mobile = mobile;
        this.email = email;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

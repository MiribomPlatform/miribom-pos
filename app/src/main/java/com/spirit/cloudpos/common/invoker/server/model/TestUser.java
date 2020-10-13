package com.spirit.cloudpos.common.invoker.server.model;

/**
 * @author changwoo.son
 */
public class TestUser {
    private String userId;
    private String userName;
    private String mobile;
    private String email;

    public TestUser() {
    }

    public TestUser(String userId, String userName, String mobile, String email) {
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

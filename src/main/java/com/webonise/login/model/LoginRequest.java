package com.webonise.login.model;

import java.io.Serializable;

public class LoginRequest implements Serializable {

    private static final long serialVersionUID = -3294365563957293428L;

    private String loginId;
    private String password;

    public LoginRequest() {
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

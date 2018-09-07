package com.kat.opentimesheet.common.dto;

import java.io.Serializable;

public class LoginReq implements Serializable {
    private String username;
    private String password;
    private boolean remember;

    public LoginReq() {
    }

    public LoginReq(String username, String password, boolean remember) {
        this.username = username;
        this.password = password;
        this.remember = remember;
    }

    @Override
    public LoginReq clone() {
        return new LoginReq(username, password, remember);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isRemember() {
        return remember;
    }

    public void setRemember(boolean remember) {
        this.remember = remember;
    }
}

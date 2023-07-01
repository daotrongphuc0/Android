package com.example.recycleviewdemo_crud.Intent_forresult;

import java.io.Serializable;

public class Account implements Serializable {
    private String username,password;

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Account() {
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
}

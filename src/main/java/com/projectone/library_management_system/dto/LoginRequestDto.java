package com.projectone.library_management_system.dto;

public class LoginRequestDto {

    // used to receive data from the client (React, Android, Postman, etc.) before it is processed by your backend.

    private String usernameOrEmail;
    private String password;

    public String getUsernameOrEmail() {
        return usernameOrEmail;
    }

    public void setUsernameOrEmail(String usernameOrEmail) {
        this.usernameOrEmail = usernameOrEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

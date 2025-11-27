package com.projectone.library_management_system.dto;

// contains the required fields for signup
public class UserRequestDto {

    // used to receive data from the client (React, Android, Postman) before it is processed by your backend.

    private String username;
    private String email;
    private String password;
    private String role;

    public UserRequestDto() {}

    public UserRequestDto(String username, String email, String password, String role) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

package com.projectone.library_management_system.dto;

public class UserDto {

    private String username;
    private String email;
    private String passsword;

    public UserDto() {}

    public UserDto(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.passsword = password;
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

    public String getPasssword() {
        return passsword;
    }

    public void setPasssword(String passsword) {
        this.passsword = passsword;
    }

}

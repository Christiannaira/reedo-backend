package com.projectone.library_management_system.dto;

import java.time.LocalDateTime;

// contains what you send back to the client
public class UserResponseDto {

    // used to send data back to the client, ensuring only the necessary and safe information is exposed.

    private Long id;
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;
    private LocalDateTime dateCreated;
    private String status;
    private String role;
    private String sex;
    private Long booksBorrowed;
    private String dateOfBirth;
    private String referenceId;

    public UserResponseDto() {}

    public UserResponseDto(Long id, String username, String email, String firstName, String lastName, String address,
                           String phoneNumber, LocalDateTime dateCreated, String status, String role, String sex, Long booksBorrowed, String dateOfBirth, String referenceId) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.dateCreated = dateCreated;
        this.status = status;
        this.role = role;
        this.sex = sex;
        this.booksBorrowed = booksBorrowed;
        this.dateOfBirth = dateOfBirth;
        this.referenceId = referenceId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Long getBooksBorrowed() {
        return booksBorrowed;
    }

    public void setBooksBorrowed(Long booksBorrowed) {
        this.booksBorrowed = booksBorrowed;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }


}

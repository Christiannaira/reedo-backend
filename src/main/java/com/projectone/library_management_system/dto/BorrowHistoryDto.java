package com.projectone.library_management_system.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class BorrowHistoryDto {

    private Long id;
    private LocalDate borrowDate;
    private LocalDate returnDate;
    private String status;

    private BookResponseDto book;
    private UserResponseDto user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BookResponseDto getBook() {
        return book;
    }

    public void setBook(BookResponseDto book) {
        this.book = book;
    }

    public UserResponseDto getUser() {
        return user;
    }

    public void setUser(UserResponseDto user) {
        this.user = user;
    }
}

package com.projectone.library_management_system.services;

import com.projectone.library_management_system.dto.BookRequestDto;
import com.projectone.library_management_system.dto.BookResponseDto;
import com.projectone.library_management_system.entity.Books;
import com.projectone.library_management_system.entity.BorrowHistory;

import java.util.List;

public interface BooksService {

    BookResponseDto addBook(BookRequestDto bookRequestDto);

    List<BookResponseDto> getAllBooks();

    BookResponseDto getBookById(Long id);

    void deleteBook(Long id);

    List<Books> searchBooks(String query);

    BookResponseDto updateBook(Long id, BookRequestDto updatedBook);




}

package com.projectone.library_management_system.services;

import com.projectone.library_management_system.dto.BookRequestDto;
import com.projectone.library_management_system.dto.BookResponseDto;

import java.util.List;

public interface BooksService {

    BookResponseDto addBook(BookRequestDto bookRequestDto);

    List<BookResponseDto> getAllBooks();

    BookResponseDto getBookById(Long id);

}

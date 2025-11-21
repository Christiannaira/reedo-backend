package com.projectone.library_management_system.services;

import com.projectone.library_management_system.dto.BookRequestDto;
import com.projectone.library_management_system.dto.BookResponseDto;

public interface BooksService {

    BookResponseDto addBook(BookRequestDto bookRequestDto);

}

package com.projectone.library_management_system.controller;

import com.projectone.library_management_system.dto.BookRequestDto;
import com.projectone.library_management_system.dto.BookResponseDto;
import com.projectone.library_management_system.dto.UserRequestDto;
import com.projectone.library_management_system.dto.UserResponseDto;
import com.projectone.library_management_system.repository.BookRepository;
import com.projectone.library_management_system.services.BooksService;
import com.projectone.library_management_system.services.impl.BooksServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BooksService booksService;
    private final BookRepository bookRepository;

    public BookController(BooksService booksService, BookRepository bookRepository) {
        this.booksService = booksService;
        this.bookRepository = bookRepository;
    }

    // add book functionality
    @PostMapping
    public ResponseEntity<BookResponseDto> addBook(@RequestBody BookRequestDto dto) {
        BookResponseDto addedBook = booksService.addBook(dto);
        return ResponseEntity.ok(addedBook);
    }

}
package com.projectone.library_management_system.controller;

import com.projectone.library_management_system.dto.BookRequestDto;
import com.projectone.library_management_system.dto.BookResponseDto;
import com.projectone.library_management_system.dto.UserRequestDto;
import com.projectone.library_management_system.dto.UserResponseDto;
import com.projectone.library_management_system.entity.Books;
import com.projectone.library_management_system.repository.BookRepository;
import com.projectone.library_management_system.services.BooksService;
import com.projectone.library_management_system.services.impl.BooksServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/books")
public class BookController {

    private final BooksService booksService;
    private final BookRepository bookRepository;

    // added a comment
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

    // getting user functionality
    @GetMapping("/{id}")
    public ResponseEntity<BookResponseDto> getBookById(@PathVariable long id) {
        BookResponseDto book = booksService.getBookById(id);
        return ResponseEntity.ok(book);
    }

    @GetMapping
    public ResponseEntity<List<BookResponseDto>> getAllBooks() {
        return ResponseEntity.ok(booksService.getAllBooks());
    }

    @GetMapping("/count")
    public Long getBookCount() {
        return bookRepository.count();
    }

    @GetMapping("/search")
    public List<Books> searchBooks(@RequestParam("q") String query) {
        String cleanedQuery = query.trim().toLowerCase();
        return booksService.searchBooks(cleanedQuery);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable long id) {
        booksService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }

    // Update a book
    @PutMapping("/{id}")
    public ResponseEntity<BookResponseDto> updateBook(
            @PathVariable Long id,
            @RequestBody BookRequestDto updatedBook) {

        return ResponseEntity.ok(booksService.updateBook(id, updatedBook));
    }

}
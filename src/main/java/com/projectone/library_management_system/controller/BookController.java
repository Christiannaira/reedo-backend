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

    // the entry point for HTTP requests (GET, POST, PUT, DELETE).

    private final BooksService booksService;
    private final BookRepository bookRepository;


    public BookController(BooksService booksService, BookRepository bookRepository) {
        this.booksService = booksService;
        this.bookRepository = bookRepository;
    }

    // ADD BOOK FUNCTIONALITY
    @PostMapping
    public ResponseEntity<?> addBook(@RequestBody BookRequestDto dto) {
        try {
            System.out.println("Incoming Book DTO: " + dto);

            BookResponseDto addedBook = booksService.addBook(dto);

            System.out.println("📤 Saved Book: " + addedBook);

            return ResponseEntity.ok(addedBook);

        } catch (Exception e) {
            System.out.println("ERROR inside addBook:");
            e.printStackTrace();

            return ResponseEntity.status(500).body("Error: " + e.getMessage());
        }
    }

    // GET BY BOOK ID FUNCTIONALITY
    @GetMapping("/{keyword}")
    public ResponseEntity<BookResponseDto> getBookById(@PathVariable long keyword) {
        BookResponseDto book = booksService.getBookById(keyword);
        return ResponseEntity.ok(book);
    }

    // GET ALL BOOKS
    @GetMapping
    public ResponseEntity<List<BookResponseDto>> getAllBooks() {
        return ResponseEntity.ok(booksService.getAllBooks());
    }

    // GET BOOKS COUNT
    @GetMapping("/count")
    public Long getBookCount() {
        return bookRepository.count();
    }


    // GET SEARCH BOOKS
    @GetMapping("/search")
    public List<BookResponseDto> searchBooks(@RequestParam("keyword") String query) {
        String cleanedQuery = query.trim().toLowerCase();
        return booksService.searchBooksDto(cleanedQuery);
    }

    // DELETE A BOOK
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable long id) {
        booksService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }

    // UPDATE A BOOK).
    @PutMapping("/{id}")
    public ResponseEntity<BookResponseDto> updateBook(
            @PathVariable Long id,
            @RequestBody BookRequestDto updatedBook) {

        return ResponseEntity.ok(booksService.updateBook(id, updatedBook));
    }

}
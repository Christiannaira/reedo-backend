package com.projectone.library_management_system.services.impl;

import com.projectone.library_management_system.dto.BookRequestDto;
import com.projectone.library_management_system.dto.BookResponseDto;
import com.projectone.library_management_system.dto.UserRequestDto;
import com.projectone.library_management_system.dto.UserResponseDto;
import com.projectone.library_management_system.entity.Books;
import com.projectone.library_management_system.entity.BorrowHistory;
import com.projectone.library_management_system.entity.Users;
import com.projectone.library_management_system.exception.ResourceNotFoundException;
import com.projectone.library_management_system.mapping.BookMapper;
import com.projectone.library_management_system.mapping.UserMapper;
import com.projectone.library_management_system.repository.BookRepository;
import com.projectone.library_management_system.repository.BorrowHistoryRepository;
import com.projectone.library_management_system.repository.UserRepository;
import com.projectone.library_management_system.services.BooksService;
import org.hibernate.sql.ast.tree.expression.Over;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.time.LocalDate;
import java.util.List;

@Service
public class BooksServiceImpl implements BooksService {

    // all book service business logic interfaces

    private final BookRepository bookRepository;


    public BooksServiceImpl (BookRepository bookRepository, UserRepository userRepository, BorrowHistoryRepository borrowHistoryRepository) {
        this.bookRepository = bookRepository;

    }

    // Create Book Business Logic
    @Override
    public BookResponseDto addBook(BookRequestDto dto) {
        Books book = BookMapper.toEntity(dto);
        bookRepository.save(book);
        return BookMapper.toDto(book);
    }

    // sorting data desc
   @Override
   public List<BookResponseDto> getAllBooks() {
        return bookRepository.findAllByOrderByCreatedAtDesc()
                .stream()
                .map(BookMapper::toDto)
                .toList();
    }

    // Get Book By id Business Logic
    @Override
    public BookResponseDto getBookById(Long id) {

        Books book = bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book not found"));

        return BookMapper.toDto(book);

    }


    // Search Book
    @Override
    public List<BookResponseDto> searchBooksDto(String keyword) {
        return bookRepository.searchBooks(keyword)
                .stream()
                .filter(b -> b != null && b.getTitle() != null)   // prevent empty/null books
                .map(BookMapper::toDto)  // use your mapper
                .toList();
    }

    // Delete Book
    @Override
    public void deleteBook(Long id) {
        Books book = bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));
        bookRepository.delete(book);
    }

    // Update Book
    @Override
    public BookResponseDto updateBook(Long id, BookRequestDto updatedBook) {

        Books existingBook = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        BookMapper.updateEntity(existingBook, updatedBook);

        bookRepository.save(existingBook);


        return BookMapper.toDto(existingBook);
    }




}

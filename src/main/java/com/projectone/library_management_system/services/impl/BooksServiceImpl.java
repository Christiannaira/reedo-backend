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
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.time.LocalDate;
import java.util.List;

@Service
public class BooksServiceImpl implements BooksService {

    private final BookRepository bookRepository;
//    private final UserRepository userRepository;
//    private final BorrowHistoryRepository borrowHistoryRepository;

    public BooksServiceImpl (BookRepository bookRepository, UserRepository userRepository, BorrowHistoryRepository borrowHistoryRepository) {
        this.bookRepository = bookRepository;
//        this.userRepository = userRepository;
//        this.borrowHistoryRepository = borrowHistoryRepository;
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
        return bookRepository.findAll()
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

//    @Override
//    public BorrowHistory borrowBook(Long userId, Long bookId) {
//
//
//        Users user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found"));
//
//        Books book = bookRepository.findById(bookId).orElseThrow(() -> new ResourceNotFoundException("Book not found"));
//
//        BorrowHistory borrowHistory = new BorrowHistory(
//                user,
//                book,
//                LocalDate.now(),
//                "Borrowed"
//        );
//
//        return borrowHistoryRepository.save(borrowHistory);
//
//    }

    @Override
    public List<Books> searchBooks(String query) {
        return bookRepository.searchBooks(query.toLowerCase());
    }

    @Override
    public void deleteBook(Long id) {
        Books book = bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));
        bookRepository.delete(book);
    }


}

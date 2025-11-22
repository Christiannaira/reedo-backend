package com.projectone.library_management_system.services.impl;

import com.projectone.library_management_system.dto.BookRequestDto;
import com.projectone.library_management_system.dto.BookResponseDto;
import com.projectone.library_management_system.dto.UserRequestDto;
import com.projectone.library_management_system.dto.UserResponseDto;
import com.projectone.library_management_system.entity.Books;
import com.projectone.library_management_system.entity.Users;
import com.projectone.library_management_system.exception.ResourceNotFoundException;
import com.projectone.library_management_system.mapping.BookMapper;
import com.projectone.library_management_system.mapping.UserMapper;
import com.projectone.library_management_system.repository.BookRepository;
import com.projectone.library_management_system.repository.UserRepository;
import com.projectone.library_management_system.services.BooksService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksServiceImpl implements BooksService {

    private final BookRepository bookRepository;

    public BooksServiceImpl (BookRepository bookRepository) {
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



}

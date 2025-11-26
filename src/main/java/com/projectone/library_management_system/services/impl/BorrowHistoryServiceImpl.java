package com.projectone.library_management_system.services.impl;

import com.projectone.library_management_system.entity.Books;
import com.projectone.library_management_system.entity.BorrowHistory;
import com.projectone.library_management_system.entity.Users;
import com.projectone.library_management_system.exception.ResourceNotFoundException;
import com.projectone.library_management_system.repository.BookRepository;
import com.projectone.library_management_system.repository.BorrowHistoryRepository;
import com.projectone.library_management_system.repository.UserRepository;
import com.projectone.library_management_system.services.BorrowHistoryService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class BorrowHistoryServiceImpl implements BorrowHistoryService {

    private final BookRepository bookRepository;
    private final UserRepository userRepository;
    private final BorrowHistoryRepository borrowHistoryRepository;

    public BorrowHistoryServiceImpl(BookRepository bookRepository, UserRepository userRepository, BorrowHistoryRepository borrowHistoryRepository) {
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
        this.borrowHistoryRepository = borrowHistoryRepository;
    }

    @Override
    public BorrowHistory borrowBookHistory(Long userId, Long bookId) {


        Users user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        Books book = bookRepository.findById(bookId).orElseThrow(() -> new ResourceNotFoundException("Book not found"));

        BorrowHistory borrowHistory = new BorrowHistory(
                user,
                book,
                LocalDate.now(),
                "Borrowed"
        );

        return borrowHistoryRepository.save(borrowHistory);






    }

}

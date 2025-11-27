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
import java.util.List;

@Service
public class BorrowHistoryServiceImpl implements BorrowHistoryService {

    // all book service business logic interfaces

    private final BookRepository bookRepository;
    private final UserRepository userRepository;
    private final BorrowHistoryRepository borrowHistoryRepository;

    public BorrowHistoryServiceImpl(BookRepository bookRepository, UserRepository userRepository, BorrowHistoryRepository borrowHistoryRepository) {
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
        this.borrowHistoryRepository = borrowHistoryRepository;
    }

    // Borrow Book

    @Override
    public BorrowHistory borrowBookHistory(Long userId, Long bookId) {


        Users user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        Books book = bookRepository.findById(bookId).orElseThrow(() -> new ResourceNotFoundException("Book not found"));

        BorrowHistory borrowHistory = new BorrowHistory(
                user,
                book,
                LocalDate.now(),
                LocalDate.now().plusDays(7),
                "Pending"
        );

        return borrowHistoryRepository.save(borrowHistory);

    }

    // Get All Borrow History

    @Override
    public List<BorrowHistory> getAllBorrowHistory() {
        return borrowHistoryRepository.findAll();
    }

    // Get All Borrow History User

    @Override
    public List<BorrowHistory> getAllBorrowHistoryByUser(Long userId) {
        return borrowHistoryRepository.findByUserId(userId);
    }

    // Get All Borrow History By Book

    @Override
    public List<BorrowHistory> getAllBorrowHistoryByBook(Long bookId) {
        return borrowHistoryRepository.findByBookId(bookId);
    }

    // Get All Borrow History

    @Override
    public BorrowHistory getBorrowHistoryById(Long id) {
        return borrowHistoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book History not found"));
    }

    // Delete Borrow History

    @Override
    public void deleteHistory(Long id) {
        BorrowHistory history = getBorrowHistoryById(id);
        borrowHistoryRepository.delete(history);
    }

    // Update Borrow History

    @Override
    public BorrowHistory updateBorrowHistory(Long id, BorrowHistory updatedHistory) {

        BorrowHistory existing = borrowHistoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book History not found"));

        // update allowed fields
        if (updatedHistory.getReturnDate() != null) {
            existing.setReturnDate(updatedHistory.getReturnDate());
        }

        if (updatedHistory.getStatus() != null) {
            existing.setStatus(updatedHistory.getStatus());
        }

        return borrowHistoryRepository.save(existing);

    }

    // Search Borrow History

    @Override
    public List<BorrowHistory> searchBorrowHistory(String term) {
        return borrowHistoryRepository.searchBorrowHistory(term);
    }

}

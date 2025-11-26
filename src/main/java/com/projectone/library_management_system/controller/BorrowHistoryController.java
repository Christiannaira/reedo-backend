package com.projectone.library_management_system.controller;

import com.projectone.library_management_system.entity.BorrowHistory;
import com.projectone.library_management_system.repository.BorrowHistoryRepository;
import com.projectone.library_management_system.services.BorrowHistoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/borrow")
@CrossOrigin("*")
public class BorrowHistoryController {

    private final BorrowHistoryService borrowHistoryService;
    private final BorrowHistoryRepository borrowHistoryRepository;


    public BorrowHistoryController(BorrowHistoryService borrowHistoryService, BorrowHistoryRepository borrowHistoryRepository) {
        this.borrowHistoryService = borrowHistoryService;
        this.borrowHistoryRepository = borrowHistoryRepository;
    }

    @PostMapping("/{userId}/{bookId}")
    public ResponseEntity<BorrowHistory> borrowBook(@PathVariable Long userId, @PathVariable Long bookId) {

        BorrowHistory borrowHistory = borrowHistoryService.borrowBookHistory(userId, bookId);
        return ResponseEntity.ok(borrowHistory);

    }

    @GetMapping
    public ResponseEntity<List<BorrowHistory>> getAll() {
        return ResponseEntity.ok(borrowHistoryService.getAllBorrowHistory());
    }

}

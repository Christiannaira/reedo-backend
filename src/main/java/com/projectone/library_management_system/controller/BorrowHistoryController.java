package com.projectone.library_management_system.controller;

import com.projectone.library_management_system.dto.BorrowHistoryDto;
import com.projectone.library_management_system.entity.BorrowHistory;
import com.projectone.library_management_system.mapping.BorrowHistoryMapper;
import com.projectone.library_management_system.repository.BorrowHistoryRepository;
import com.projectone.library_management_system.services.BorrowHistoryService;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

//    @GetMapping
//    public ResponseEntity<List<BorrowHistory>> getAll() {
//        return ResponseEntity.ok(borrowHistoryService.getAllBorrowHistory());
//    }
    @GetMapping
    public ResponseEntity<List<BorrowHistoryDto>> getAll() {
        return ResponseEntity.ok(
                borrowHistoryService.getAllBorrowHistory()
                        .stream()
                        .map(BorrowHistoryMapper::toDto)
                        .toList()
        );
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<BorrowHistory>> getByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(borrowHistoryService.getAllBorrowHistoryByUser(userId));
    }

//    @GetMapping("/user/{userId}")
//    public ResponseEntity<List<BorrowHistoryDto>> getByUser(@PathVariable Long userId) {
//        return ResponseEntity.ok(
//                borrowHistoryService.getAllBorrowHistoryByUser(userId)
//                        .stream()
//                        .map(BorrowHistoryMapper::toDto)
//                        .toList()
//        );
//    }

    @GetMapping("/book/{bookId}")
    public ResponseEntity<List<BorrowHistory>> getByBook(@PathVariable Long bookId) {
        return ResponseEntity.ok(borrowHistoryService.getAllBorrowHistoryByBook(bookId));
    }

    @GetMapping("/{historyId}")
    public ResponseEntity<BorrowHistory> getById(@PathVariable Long historyId) {
        return ResponseEntity.ok(borrowHistoryService.getBorrowHistoryById(historyId));
    }

    @DeleteMapping("/{historyId}")
    public ResponseEntity<Void> delete(@PathVariable Long historyId) {
        borrowHistoryService.deleteHistory(historyId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{historyId}")
    public ResponseEntity<BorrowHistory> updateHistory(@PathVariable Long historyId, @RequestBody BorrowHistory updatedHistory) {

        BorrowHistory history = borrowHistoryService.updateBorrowHistory(historyId, updatedHistory);
        return ResponseEntity.ok(history);

    }

//    @GetMapping("/search")
//    public List<BorrowHistory> searchBorrowHistory( @RequestParam(value = "search", required = false) String search) {
//
//        if (search != null && !search.trim().isEmpty()) {
//            return borrowHistoryService.searchBorrowHistory(search);
//        }
//
//        return borrowHistoryService.getAllBorrowHistory();
//
//    }

    @GetMapping("/search")
    public ResponseEntity<List<BorrowHistory>> search(
            @RequestParam("q") String q) {

        if (q == null || q.trim().isEmpty()) {
            return ResponseEntity.ok(borrowHistoryService.getAllBorrowHistory());
        }

        return ResponseEntity.ok(borrowHistoryService.searchBorrowHistory(q));
    }


}

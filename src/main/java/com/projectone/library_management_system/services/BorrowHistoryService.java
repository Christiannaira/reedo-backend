package com.projectone.library_management_system.services;

import com.projectone.library_management_system.entity.BorrowHistory;

import java.util.List;

public interface BorrowHistoryService {

    BorrowHistory borrowBookHistory(Long id, Long bookId);

    List<BorrowHistory> getAllBorrowHistory();

//    List<BorrowHistory> getAllBorrowHistoryByUser(Long userId);
//
//    List<BorrowHistory> getAllBorrowHistoryByBook(Long bookId);
//
//    BorrowHistory returnBook(Long bookHistoryId);
//
//    void deleteHistory(Long bookId);
//
//    BorrowHistory getBorrowHistoryById(Long id);



}

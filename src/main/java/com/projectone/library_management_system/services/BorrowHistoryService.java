package com.projectone.library_management_system.services;

import com.projectone.library_management_system.entity.BorrowHistory;

public interface BorrowHistoryService {

    BorrowHistory borrowBookHistory(Long id, Long bookId);

}

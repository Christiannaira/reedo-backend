package com.projectone.library_management_system.repository;

import com.projectone.library_management_system.entity.BorrowHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BorrowHistoryRepository extends JpaRepository<BorrowHistory, Long> {

    List<BorrowHistory> findByUserId(Long userId);

    List<BorrowHistory> findByBookId(Long bookId);

}

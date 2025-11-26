package com.projectone.library_management_system.repository;

import com.projectone.library_management_system.entity.BorrowHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BorrowHistoryRepository extends JpaRepository<BorrowHistory, Long> {

    List<BorrowHistory> findByUserId(Long userId);

    List<BorrowHistory> findByBookId(Long bookId);

//    @Query("""
//        SELECT bh FROM BorrowHistory bh
//        JOIN bh.user u
//        JOIN bh.book b
//        WHERE LOWER(u.username) LIKE LOWER(CONCAT('%', :searchTerm, '%'))
//           OR LOWER(u.firstName) LIKE LOWER(CONCAT('%', :searchTerm, '%'))
//           OR LOWER(u.lastName) LIKE LOWER(CONCAT('%', :searchTerm, '%'))
//           OR LOWER(b.title) LIKE LOWER(CONCAT('%', :searchTerm, '%'))
//           OR LOWER(b.author) LIKE LOWER(CONCAT('%', :searchTerm, '%'))
//    """)
//    List<BorrowHistory> searchBorrowHistory(@Param("searchTerm") String searchTerm);

    @Query("""
        SELECT bh FROM BorrowHistory bh
        LEFT JOIN bh.user u
        LEFT JOIN bh.book b
        WHERE LOWER(u.username) LIKE LOWER(CONCAT('%', :term, '%'))
           OR LOWER(u.firstName) LIKE LOWER(CONCAT('%', :term, '%'))
           OR LOWER(u.lastName) LIKE LOWER(CONCAT('%', :term, '%'))
           OR LOWER(b.title) LIKE LOWER(CONCAT('%', :term, '%'))
           OR LOWER(b.author) LIKE LOWER(CONCAT('%', :term, '%'))
    """)
    List<BorrowHistory> searchBorrowHistory(@Param("term") String term);



}

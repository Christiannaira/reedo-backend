package com.projectone.library_management_system.repository;

import com.projectone.library_management_system.entity.Books;
import com.projectone.library_management_system.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.awt.print.Book;
import java.util.List;

public interface BookRepository extends JpaRepository<Books, Long> {


    @Query("SELECT DISTINCT b FROM Books b LEFT JOIN b.tags t " +
            "WHERE LOWER(b.title) LIKE LOWER(CONCAT('%', :searchTerm, '%')) " +
            "OR LOWER(b.author) LIKE LOWER(CONCAT('%', :searchTerm, '%')) " +
            "OR LOWER(b.genre) LIKE LOWER(CONCAT('%', :searchTerm, '%')) " +
            "OR LOWER(t) LIKE LOWER(CONCAT('%', :searchTerm, '%'))")

    List<Books> searchBooks(@Param("searchTerm") String searchTerm);



}

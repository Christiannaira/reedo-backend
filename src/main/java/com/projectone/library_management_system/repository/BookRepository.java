package com.projectone.library_management_system.repository;

import com.projectone.library_management_system.entity.Books;
import com.projectone.library_management_system.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.awt.print.Book;
import java.util.List;

public interface BookRepository extends JpaRepository<Books, Long> {


    //Layer responsible for communicating with the database.
    //In Spring Boot, repositories are built using Spring Data JPA, which automatically generates database operations

    @Query("SELECT DISTINCT b FROM Books b LEFT JOIN b.tags t " +
            "WHERE LOWER(b.title) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(b.author) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(b.genre) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(t) LIKE LOWER(CONCAT('%', :keyword, '%'))")


    List<Books> searchBooks(@Param("keyword") String keyword);

    List<Books> findAllByOrderByCreatedAtDesc();



}

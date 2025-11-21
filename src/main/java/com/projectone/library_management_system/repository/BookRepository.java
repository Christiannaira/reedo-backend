package com.projectone.library_management_system.repository;

import com.projectone.library_management_system.entity.Books;
import com.projectone.library_management_system.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Book;
import java.util.List;

public interface BookRepository extends JpaRepository<Books, Long> {


}

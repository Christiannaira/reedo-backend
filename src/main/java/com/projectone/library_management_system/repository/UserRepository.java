package com.projectone.library_management_system.repository;

import com.projectone.library_management_system.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<Users, Long> {

    // sorting data desc
    List<Users> findAllByOrderByDateCreatedDesc();

}

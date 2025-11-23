package com.projectone.library_management_system.repository;

import com.projectone.library_management_system.entity.Users;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<Users, Long> {

    // sorting data desc
    List<Users> findAllByOrderByDateCreatedDesc();

//    List<Users> findByUsernameContainingIgnoreCase(String username);
//
//    List<Users> findByEmailContainingIgnoreCase(String email);

    List<Users> findByUsernameContainingIgnoreCaseOrFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrEmailContainingIgnoreCase(String username, String firstName, String lastName, String email);

}

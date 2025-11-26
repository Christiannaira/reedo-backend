package com.projectone.library_management_system.repository;

import com.projectone.library_management_system.entity.Users;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {

    // sorting data desc
    List<Users> findAllByOrderByDateCreatedDesc();

    List<Users> findByUsernameContainingIgnoreCaseOrFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrEmailContainingIgnoreCase(String username, String firstName, String lastName, String email);

    Optional<Users> findByUsernameOrEmail(String username, String email);

    Optional<Users> findByFirstNameAndLastNameAndEmail(String firstName, String lastName, String email);


}

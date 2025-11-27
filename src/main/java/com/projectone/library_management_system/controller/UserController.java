package com.projectone.library_management_system.controller;

import com.projectone.library_management_system.dto.*;
import com.projectone.library_management_system.entity.Users;
import com.projectone.library_management_system.repository.UserRepository;
import com.projectone.library_management_system.services.UsersService;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/users")
public class UserController {

    // the entry point for HTTP requests (GET, POST, PUT, DELETE).

    private final UsersService usersService;
    private final UserRepository userRepository;

    public UserController(UsersService usersService, UserRepository userRepository) {
        this.usersService = usersService;
        this.userRepository = userRepository;
    }

    // SIGN UP FUNCTIONALITY
    @PostMapping
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserRequestDto dto) {
        UserResponseDto createdUser = usersService.createUser(dto);
        return ResponseEntity.ok(createdUser);
    }

    // GETTING USER BY ID FUNCTIONALITY
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getUserById(@PathVariable long id) {
        UserResponseDto user = usersService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    // UPDATE USER FUNCTIONALITY
    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDto> updateUser(@PathVariable long id, @RequestBody UserProfileDto dto) {
        UserResponseDto updatedUser = usersService.updateUserProfile(id, dto);
        return ResponseEntity.ok(updatedUser);
    }

    // GET ALL USERS FUNCTIONALITY
    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getAllUsers() {
        return ResponseEntity.ok(usersService.getAllUsers());
    }

    // DELETE USER FUNCTIONALITY
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable long id) {
        usersService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    // GET USERS COUNT FUNCTIONALITY
    @GetMapping("/count")
    public Long getUserCount() {
        return userRepository.count();
    }

    // GET SEARCH USER FUNCTIONALITY
    @GetMapping("/search")
    public List<Users> searchUsers(@RequestParam("keyword") String keyword) {
        return usersService.searchUsers(keyword);
    }

    // ADMIN LOGIN FUNCTIONALITY
    @PostMapping("/adminLogin")
    public ResponseEntity<?> login(@RequestBody LoginRequestDto request) {

        Users user = usersService.login(request.getUsernameOrEmail(), request.getPassword());

        if (user != null) {
            return ResponseEntity.ok("Login successful. Welcome " + user.getUsername());
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid login credentials");

        }

    }

    // USER LOGIN FUNCTIONALITY
    @PostMapping("/userLogin")
    public ResponseEntity<?> userLogin(@RequestBody LoginRequestDto request) {

        Users user = usersService.userLogin(request.getUsernameOrEmail(), request.getPassword());

        if (user != null) {
            return ResponseEntity.ok("Login successful. Welcome " + user.getUsername());
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid login credentials");

        }

    }

    // GUEST LOGIN FUNCTIONALITY
    @PostMapping("/guest")
    public ResponseEntity<UserResponseDto> createNonUser(@RequestBody GuestRequestDto dto) {
        System.out.println("Guest DTO received: " + dto);
        UserResponseDto response = usersService.createGuest(dto);
        System.out.println("Created guest: " + response);
        return ResponseEntity.ok(response);
    }



}

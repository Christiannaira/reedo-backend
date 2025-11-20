package com.projectone.library_management_system.controller;

import com.projectone.library_management_system.dto.UserDto;
import com.projectone.library_management_system.dto.UserProfileDto;
import com.projectone.library_management_system.dto.UserRequestDto;
import com.projectone.library_management_system.dto.UserResponseDto;
import com.projectone.library_management_system.entity.Users;
import com.projectone.library_management_system.services.UsersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UsersService usersService;

    public UserController(UsersService usersService) {
        this.usersService = usersService;
    }

    // signup functionality
    @PostMapping
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserRequestDto dto) {
        UserResponseDto createdUser = usersService.createUser(dto);
        return ResponseEntity.ok(createdUser);
    }

    // getting user functionality
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getUserById(@PathVariable long id) {
        UserResponseDto user = usersService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/{id}/profile")
    public ResponseEntity<UserResponseDto> updateUser(@PathVariable long id, @RequestBody UserProfileDto dto) {
        UserResponseDto updatedUser = usersService.updateUserProfile(id, dto);
        return ResponseEntity.ok(updatedUser);
    }


}

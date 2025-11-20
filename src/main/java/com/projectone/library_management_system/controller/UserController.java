package com.projectone.library_management_system.controller;

import com.projectone.library_management_system.dto.UserDto;
import com.projectone.library_management_system.dto.UserRequestDto;
import com.projectone.library_management_system.dto.UserResponseDto;
import com.projectone.library_management_system.entity.Users;
import com.projectone.library_management_system.services.UsersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}

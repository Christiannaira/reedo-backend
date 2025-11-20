package com.projectone.library_management_system.controller;

import com.projectone.library_management_system.dto.UserDto;
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

//    @PostMapping
//    public ResponseEntity<UserDto> addUser(@RequestBody Users dto) {
//        Users addedUser = usersService.createUser(dto);
//    }

}

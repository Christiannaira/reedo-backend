package com.projectone.library_management_system.services;

import com.projectone.library_management_system.dto.UserDto;
import com.projectone.library_management_system.dto.UserProfileDto;
import com.projectone.library_management_system.dto.UserRequestDto;
import com.projectone.library_management_system.dto.UserResponseDto;
import com.projectone.library_management_system.entity.Users;

import java.util.List;

public interface UsersService {

    UserResponseDto createUser(UserRequestDto dto);

    UserResponseDto getUserById(Long id);

    UserResponseDto updateUserProfile(Long id, UserProfileDto dto);

    List<UserResponseDto> getAllUsers();

    void deleteUser(Long id);

    List<Users> searchUsers(String keyword);

    Users login(String usernameOrEmail, String password);

    Users userLogin(String usernameOrEmail, String password);



}

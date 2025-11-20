package com.projectone.library_management_system.services;

import com.projectone.library_management_system.dto.UserDto;
import com.projectone.library_management_system.dto.UserProfileDto;
import com.projectone.library_management_system.dto.UserRequestDto;
import com.projectone.library_management_system.dto.UserResponseDto;

public interface UsersService {

    UserResponseDto createUser(UserRequestDto dto);

    UserResponseDto getUserById(Long id);

    UserResponseDto updateUserProfile(Long id, UserProfileDto dto);



}

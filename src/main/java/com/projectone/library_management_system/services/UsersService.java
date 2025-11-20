package com.projectone.library_management_system.services;

import com.projectone.library_management_system.dto.UserDto;
import com.projectone.library_management_system.dto.UserRequestDto;
import com.projectone.library_management_system.dto.UserResponseDto;

public interface UsersService {

    UserResponseDto createUser(UserRequestDto dto);

    public UserResponseDto getUserById(Long id);



}

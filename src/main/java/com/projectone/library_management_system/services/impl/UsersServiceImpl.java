package com.projectone.library_management_system.services.impl;

import com.projectone.library_management_system.dto.UserProfileDto;
import com.projectone.library_management_system.dto.UserRequestDto;
import com.projectone.library_management_system.dto.UserResponseDto;
import com.projectone.library_management_system.entity.Users;
import com.projectone.library_management_system.exception.ResourceNotFoundException;
import com.projectone.library_management_system.mapping.UserMapper;
import com.projectone.library_management_system.repository.UserRepository;
import com.projectone.library_management_system.services.UsersService;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService {

    private final UserRepository userRepository;


    public UsersServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Create User Business Logic
    @Override
    public UserResponseDto createUser(UserRequestDto dto) {
        Users user = UserMapper.toEntity(dto);
        userRepository.save(user);
        return UserMapper.toDto(user);
    }

    // Get User By id Business Logic
    @Override
    public UserResponseDto getUserById(Long id) {

        Users user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(
                "User with ID " + id + " not found."
        ));

        return UserMapper.toDto(user);

    }

    // Update Profile (FIRSTNAME/LASTNAME/PHONE/ADDRESS)
    @Override
    public UserResponseDto updateUserProfile(Long id, UserProfileDto dto) {

        // Fetch existing user
        Users user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(
                "User with ID " + id + " not found."
        ));

        // Update only provided fields
        UserMapper.updateFromProfileDto(user, dto);

        // Save updated user
        user = userRepository.save(user);

        return UserMapper.toDto(user);

    }




}

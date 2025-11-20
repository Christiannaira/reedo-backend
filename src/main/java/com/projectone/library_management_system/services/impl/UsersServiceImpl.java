package com.projectone.library_management_system.services.impl;

import com.projectone.library_management_system.dto.UserRequestDto;
import com.projectone.library_management_system.dto.UserResponseDto;
import com.projectone.library_management_system.entity.Users;
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


    public UserResponseDto createUser(UserRequestDto dto) {
        Users user = UserMapper.toEntity(dto);
        userRepository.save(user);
        return UserMapper.toDto(user);
    }



}

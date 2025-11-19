package com.projectone.library_management_system.services.impl;

import com.projectone.library_management_system.dto.UserDto;
import com.projectone.library_management_system.entity.Users;
import com.projectone.library_management_system.mapping.UserMapper;
import com.projectone.library_management_system.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl {

    private final UserRepository userRepository;

    public UsersServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto createUser(UserDto dto) {

        Users user = UserMapper.toEntity(dto);
        user = userRepository.save(user);
        return UserMapper.toDto(user);

    }

}

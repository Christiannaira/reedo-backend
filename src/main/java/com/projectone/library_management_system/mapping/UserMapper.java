package com.projectone.library_management_system.mapping;

import com.projectone.library_management_system.dto.UserDto;
import com.projectone.library_management_system.dto.UserRequestDto;
import com.projectone.library_management_system.entity.Users;
import org.apache.catalina.User;

public class UserMapper {

    // UserDTO to User Entity
    public static Users toEntity(UserRequestDto dto) {
        if (dto == null) return null;
        return new Users(dto.getUsername(), dto.getEmail(), dto.getPassword());
    }

    // User Entity to UserDTO
    public static UserDto toDto(Users users) {
        if (users == null) return null;

        UserDto dto = new UserDto();
        dto.setUsername(users.getUsername());
        dto.setEmail(users.getEmail());

        return dto;

    }

}

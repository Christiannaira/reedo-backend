package com.projectone.library_management_system.mapping;

import com.projectone.library_management_system.dto.UserDto;
import com.projectone.library_management_system.dto.UserProfileDto;
import com.projectone.library_management_system.dto.UserRequestDto;
import com.projectone.library_management_system.dto.UserResponseDto;
import com.projectone.library_management_system.entity.Users;
import org.apache.catalina.User;

public class UserMapper {

    // UserDTO to User Entity
    public static Users toEntity(UserRequestDto dto) {
        if (dto == null) return null;
        return new Users(dto.getUsername(), dto.getEmail(), dto.getPassword());
    }

    // User Entity to UserDTO
    public static UserResponseDto toDto(Users users) {
        if (users == null) return null;

       UserResponseDto dto = new UserResponseDto();
       dto.setUsername(users.getUsername());
       dto.setEmail(users.getEmail());
       dto.setFirstName(users.getFirstName());
       dto.setLastName(users.getLastName());
       dto.setAddress(users.getAddress());
       dto.setPhoneNumber(String.valueOf(users.getPhoneNumber()));
       dto.setDateCreated(users.getDateCreated());
       dto.setStatus(users.getStatus());
       dto.setRole(users.getRole());

       return dto;

    }

    // Update existing User entity from UserProfile
    public static void updateFromProfileDto(Users user, UserProfileDto dto) {
        if (dto == null || user == null) return;

        if (dto.getFirstName() != null) user.setFirstName(dto.getFirstName());
        if (dto.getLastName() != null) user.setLastName(dto.getLastName());
        if (dto.getAddress() != null) user.setAddress(dto.getAddress());
        if (dto.getPhoneNumber() != null) user.setPhoneNumber(dto.getPhoneNumber());
        if (dto.getEmail() != null) user.setEmail(dto.getEmail());
        if (dto.getUsername() != null) user.setUsername(dto.getUsername());
        if (dto.getStatus() != null) user.setStatus(dto.getStatus());
        if (dto.getRole() != null) user.setRole(dto.getRole());
    }

}

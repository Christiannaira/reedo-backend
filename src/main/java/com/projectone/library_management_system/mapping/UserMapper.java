package com.projectone.library_management_system.mapping;

import com.projectone.library_management_system.dto.*;
import com.projectone.library_management_system.entity.Users;
import org.apache.catalina.User;

public class UserMapper {

    // UserDTO to User Entity
    public static Users toEntity(UserRequestDto dto) {
        if (dto == null) return null;
        return new Users(dto.getUsername(), dto.getEmail(), dto.getPassword(), dto.getRole());
    }

    // User Entity to UserDTO
    public static UserResponseDto toDto(Users users) {
        if (users == null) return null;

       UserResponseDto dto = new UserResponseDto();
       dto.setId(users.getId());
       dto.setUsername(users.getUsername());
       dto.setEmail(users.getEmail());
       dto.setFirstName(users.getFirstName());
       dto.setLastName(users.getLastName());
       dto.setAddress(users.getAddress());
       dto.setPhoneNumber(String.valueOf(users.getPhoneNumber()));
       dto.setDateCreated(users.getDateCreated());
       dto.setStatus(users.getStatus());
       dto.setRole(users.getRole());
       dto.setSex(users.getSex());
       dto.setBooksBorrowed(users.getBooksBorrowed());
       dto.setDateOfBirth(users.getDateOfBirth());
       dto.setReferenceId(users.getReferenceId());

       return dto;

    }

    // Update existing User entity from UserProfile
    public static void updateFromProfileDto(Users user, UserProfileDto dto) {
        if (dto == null || user == null) return;

        if (dto.getId() != null) user.setId(dto.getId());
        if (dto.getFirstName() != null) user.setFirstName(dto.getFirstName());
        if (dto.getLastName() != null) user.setLastName(dto.getLastName());
        if (dto.getAddress() != null) user.setAddress(dto.getAddress());
        if (dto.getPhoneNumber() != null) user.setPhoneNumber(dto.getPhoneNumber());
        if (dto.getEmail() != null) user.setEmail(dto.getEmail());
        if (dto.getUsername() != null) user.setUsername(dto.getUsername());
        if (dto.getStatus() != null) user.setStatus(dto.getStatus());
        if (dto.getRole() != null) user.setRole(dto.getRole());
        if (dto.getSex() != null) user.setSex(dto.getSex());
        if (dto.getBooksBorrowed() != null) user.setBooksBorrowed(dto.getBooksBorrowed());
        if (dto.getDateOfBirth() != null) user.setDateOfBirth(dto.getDateOfBirth());
        if (dto.getReferenceId() != null) user.setReferenceId(dto.getReferenceId());
    }

    public static Users toGuestEntity(GuestRequestDto dto) {
        Users guest = new Users();
        guest.setUsername("guest_" + + System.currentTimeMillis());
        guest.setEmail(dto.getEmail());
        guest.setFirstName(dto.getFirstName());
        guest.setLastName(dto.getLastName());
        guest.setAddress(dto.getAddress());
        guest.setPhoneNumber(dto.getPhoneNumber());
        guest.setRole("Guest");
        guest.setStatus("Not Verified");
        guest.setPassword("GUEST");
        return guest;
    }

    public static UserResponseDto toGuestDto(Users user){
        UserResponseDto dto = new UserResponseDto();
        dto.setId(user.getId());
        dto.setEmail(user.getEmail());
        dto.setUsername(user.getUsername());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setAddress(user.getAddress());
        dto.setPhoneNumber(user.getPhoneNumber());
        dto.setRole(user.getRole());
        dto.setStatus(user.getStatus());
        return dto;
    }

}

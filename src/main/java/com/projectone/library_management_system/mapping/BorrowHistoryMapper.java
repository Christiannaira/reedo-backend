package com.projectone.library_management_system.mapping;

import com.projectone.library_management_system.dto.BorrowHistoryDto;
import com.projectone.library_management_system.entity.BorrowHistory;

public class BorrowHistoryMapper {

    // responsible for converting data between:
    // Entity → ResponseDTO (when sending data to frontend)
    //RequestDTO → Entity (when receiving data from frontend)

    public static BorrowHistoryDto toDto(BorrowHistory h) {
        BorrowHistoryDto dto = new BorrowHistoryDto();

        dto.setId(h.getId());
        dto.setBorrowDate(h.getBorrowDate());
        dto.setReturnDate(h.getReturnDate());
        dto.setStatus(h.getStatus());

        dto.setBook(BookMapper.toDto(h.getBook()));
        dto.setUser(UserMapper.toDto(h.getUser()));

        return dto;

    }

}

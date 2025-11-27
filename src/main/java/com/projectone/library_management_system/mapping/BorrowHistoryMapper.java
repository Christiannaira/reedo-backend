package com.projectone.library_management_system.mapping;

import com.projectone.library_management_system.dto.BorrowHistoryDto;
import com.projectone.library_management_system.entity.BorrowHistory;

public class BorrowHistoryMapper {

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

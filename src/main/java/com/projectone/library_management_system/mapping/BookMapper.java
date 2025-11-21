package com.projectone.library_management_system.mapping;

import com.projectone.library_management_system.dto.BookRequestDto;
import com.projectone.library_management_system.dto.BookResponseDto;
import com.projectone.library_management_system.entity.Books;

public class BookMapper {

    public static Books toEntity(BookRequestDto dto) {
        if (dto == null) return null;
        return new Books(dto.getTitle(), dto.getAuthor(), dto.getPublisher(), dto.getPublicationDate(), dto.getIsbn(), dto.getGenre(),
                dto.getLanguage(), dto.getNumberOfPages(), dto.getSummary(), dto.getCopiesAvailable(), dto.getTotalCopies(), dto.getStatus(), dto.getCoverImageUrl(), dto.getTags());
    }

    public static BookResponseDto toDto(Books books) {
        if (books == null) return null;

        BookResponseDto dto = new BookResponseDto();
        dto.setId(books.getId());
        dto.setTitle(books.getTitle());
        dto.setAuthor(books.getAuthor());
        dto.setPublisher(books.getPublisher());
        dto.setPublicationDate(books.getPublicationDate());
        dto.setIsbn(books.getIsbn());
        dto.setGenre(books.getGenre());
        dto.setLanguage(books.getLanguage());
        dto.setNumberOfPages(books.getNumberOfPages());
        dto.setSummary(books.getSummary());
        dto.setCopiesAvailable(books.getCopiesAvailable());
        dto.setTotalCopies(books.getTotalCopies());
        dto.setStatus(books.getStatus());
        dto.setCoverImageUrl(books.getCoverImagUrl());
        dto.setTags(books.getTags());

        return dto;

    }

}

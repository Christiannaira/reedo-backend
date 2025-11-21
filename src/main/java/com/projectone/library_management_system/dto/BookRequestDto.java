package com.projectone.library_management_system.dto;

import jakarta.persistence.Column;

import java.util.ArrayList;
import java.util.List;

public class BookRequestDto {

    private String title;
    private String author;
    private String publisher;
    private String publicationDate;
    private String isbn;
    private String genre;
    private String language;
    private Integer numberOfPages;
    private String summary;
    private Integer copiesAvailable;
    private Integer totalCopies;
    private String status;
    private String coverImageUrl;
    private List<String> tags = new ArrayList<>();

    public BookRequestDto() {}

    public BookRequestDto(String title, String author, String publisher, String publicationDate, String isbn, String genre,
                          String language,Integer numberOfPages, String summary, Integer copiesAvailable, Integer totalCopies, String status, String coverImageUrl, List<String> tags) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.publicationDate = publicationDate;
        this.isbn = isbn;
        this.genre = genre;
        this.language = language;
        this.numberOfPages = numberOfPages;
        this.summary = summary;
        this.copiesAvailable = copiesAvailable;
        this.totalCopies = totalCopies;
        this.status = status;
        this.coverImageUrl = coverImageUrl;
        this.tags = tags;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(Integer numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Integer getCopiesAvailable() {
        return copiesAvailable;
    }

    public void setCopiesAvailable(Integer copiesAvailable) {
        this.copiesAvailable = copiesAvailable;
    }

    public Integer getTotalCopies() {
        return totalCopies;
    }

    public void setTotalCopies(Integer totalCopies) {
        this.totalCopies = totalCopies;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCoverImageUrl() {
        return coverImageUrl;
    }

    public void setCoverImageUrl(String coverImageUrl) {
        this.coverImageUrl = coverImageUrl;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}

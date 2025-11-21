package com.projectone.library_management_system.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="books")
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String publisher;

    @Column(nullable = false)
    private String publicationDate;

    @Column(nullable = false)
    private String isbn;

    @Column(nullable = false)
    private String genre;

    @Column(nullable = false)
    private String language;

    @Column(nullable = false)
    private Integer numberOfPages;

    @Column(nullable = false)
    private String summary;

    @Column(nullable = false)
    private Integer copiesAvailable;

    @Column(nullable = false)
    private Integer totalCopies;

    @Column(nullable = false)
    private String status;
    @Column(nullable = false)
    private String coverImageUrl;

    @Column(nullable = false)
    private List<String> tags = new ArrayList<>();

    public Books() {}

    public Books(String title, String author, String publisher, String publicationDate, String isbn, String genre,
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getCoverImagUrl() {
        return coverImageUrl;
    }

    public void setCoverImagUrl(String coverImagUrl) {
        this.coverImageUrl = coverImagUrl;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}

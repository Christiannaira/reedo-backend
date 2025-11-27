package com.projectone.library_management_system.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="books")
public class Books {

    // Entities represents a database table

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    @Column(nullable = true)
    private String publisher;

    @Column(nullable = true)
    private String publicationDate;

    @Column(nullable = true)
    private String isbn;

    @Column(nullable = true)
    private String genre;

    @Column(nullable = true)
    private String language;

    @Column(nullable = true)
    private Integer numberOfPages;

    @Column(nullable = true)
    private String summary;

    @Column(nullable = true)
    private Integer copiesAvailable;

    @Column(nullable = true)
    private Integer totalCopies;

    @Column(nullable = true)
    private String status;
    @Column(nullable = true)
    private String coverImageUrl;

    @ElementCollection
    @CollectionTable(name = "book_tags", joinColumns = @JoinColumn(name = "book_id"))
    @Column(name = "tag")
    private List<String> tags = new ArrayList<>();

    @OneToMany(mappedBy = "book") // One user → can have many related records.
    private List<BorrowHistory> borrowHistory;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    //It tells Hibernate/Spring Data JPA to run this method automatically before the entity is saved to the database for the first time.

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    // constructor overloading

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

    // encapsulation

    public String getCoverImageUrl() {
        return coverImageUrl;
    }

    public void setCoverImageUrl(String coverImageUrl) {
        this.coverImageUrl = coverImageUrl;
    }

    public List<BorrowHistory> getBorrowHistory() {
        return borrowHistory;
    }

    public void setBorrowHistory(List<BorrowHistory> borrowHistory) {
        this.borrowHistory = borrowHistory;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
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

package com.georgeOrg.library.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

@Entity
@Table(name = "Books")
public class Book {
    @Id
    @GeneratedValue
    private long id;

    @NotBlank(message = "Published Date is mandatory.")
    private LocalDate publishedDate;


    private int authorId;

    private int memberId;

    @NotBlank(message = "ISBN is mandatory.")
    private String isbn;

    @NotBlank(message = "Title is mandatory.")
    private String title;

    @ManyToOne
    @JoinColumn(name = "member_Id", nullable = false)
    private Member member;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;

    public Book(LocalDate publishedDate, int authorId, int memberId, String isbn, String title) {
        this.publishedDate = publishedDate;
        this.authorId = authorId;
        this.memberId = memberId;
        this.isbn = isbn;
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

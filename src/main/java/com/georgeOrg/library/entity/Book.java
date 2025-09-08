package com.georgeOrg.library.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

@Entity
@Table(name = "Books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @PastOrPresent(message = "The date can not be in the future.")
    @NotBlank(message = "Published Date is mandatory.")
    private LocalDate publishedDate;

    @NotBlank(message = "ISBN is mandatory.")
    private String isbn;

    @NotBlank(message = "Title is mandatory.")
    private String title;

    @ManyToOne
    @JoinColumn(name = "member_Id", nullable = false) // Underscore is the best practice for naming database, because is the best
    private Member member;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;

    public Book(LocalDate publishedDate, String isbn, String title, Member member, Author author) {
        this.publishedDate = publishedDate;
        this.isbn = isbn;
        this.title = title;
        this.member = member;
        this.author = author;
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
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

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public long getId() {
        return id;
    }
 // I removed the set, because is auto incremented

}

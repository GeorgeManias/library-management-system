package com.georgeOrg.library.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Tables")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Past(message = "Date of Birth must be in the past.")
    private LocalDate dob;

    @Email(message = "This field is an email.")
    @NotBlank(message = "email is mandatory value.")
    private String email;

    @NotBlank(message = "Name is mandatory value.")
    private String name;


    //In the line 29 of member, this is the variable name of the member inside the bookclass. Which books are related to that member?
    //cascadeType to all, if this member is deleted, removes automatically all the relations.
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Book> books;

    public Member(LocalDate dob, String email, String name) {
        this.dob = dob;
        this.email = email;
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}

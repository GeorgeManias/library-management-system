package com.georgeOrg.library.entity;

// The entity contains all the tables of database

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.time.LocalDate;

@Entity // Is the annotation for telling Spring Boot, that this class reflect in the database
@Table(name = "Authors")//To tell the name of the table
public class Author {


    @Id // this says that this the id of the table
    @GeneratedValue(strategy = GenerationType.IDENTITY) //This is to make the auto increment
    private long id;

    @NotBlank(message = "Name is mandatory.")
    @Size(min = 2, message = "2 Characters minimum.") // minimum characters
    private String name;

    @Past(message = "Date of Birth must be in the past.")
    private LocalDate dob;

    @NotBlank(message = "Biography is mandatory.")
    private String biography;

    //id will not be available from the constructor, because it is generated automatically
    public Author(String name, LocalDate dob, String biography) {
        this.name = name;
        this.dob = dob;
        this.biography = biography;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }
}

package com.georgeOrg.library.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;

@Entity
@Table(name = "Tables")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Past(message = "Date of Birth must be in the past.")
    private LocalDate dob;

    @NotBlank(message = "email is mandatory value.")
    private String email;

    @NotBlank(message = "Name is mandatory value.")
    private String name;






}

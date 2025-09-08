package com.georgeOrg.library.repository;

import com.georgeOrg.library.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

// this is the Database Layer which manages the Tables
//JpaRepository  It is related to hybernate, it provides functions on the database.
//JpaRepository<Author, Long> this is a datype of the id of the author.
public interface AuthorRepository extends JpaRepository<Author, Long>  {

}

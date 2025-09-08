package com.georgeOrg.library.service;

import com.georgeOrg.library.entity.Author;
import com.georgeOrg.library.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// Service is the layer to have in order to use the entity and the repository.
//Communicates with repository layer.
@Service // This is telling Spring Boot that this is a service layer. And defining this class as a bean
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    public List<Author> getAllAuthors(){
        List<Author> authors= authorRepository.findAll(); // authorRepository.findAll() this is like SELECT*
        return authors;
    }

    public Author addAuthor(Author author){
        return authorRepository.save(author);

        // It takes the author I sent and sending in to the database.
    }


}

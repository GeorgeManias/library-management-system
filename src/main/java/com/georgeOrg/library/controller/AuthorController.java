package com.georgeOrg.library.controller;

import com.georgeOrg.library.entity.Author;
import com.georgeOrg.library.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
// The entity is not the BestPractice to use in the controller layer. DTO = Data Transfering Object. Is a class that it main concern is to receive data
// through the APIs.
//In order to exclude some fields for security and in general it give nore flexibility


// Here we use the logic of the service layer.
// Creating the APIs itself and communicates with the Service layer.
@RestController
// It is telling that is a controller layer. It defines this class as a bean (responsible for the dependency injection)
@RequestMapping("/authors")
// this is the adress of the Authors controller (best practice not to use CAPITAL in mapping)
public class AuthorController {
    @Autowired
    AuthorService authorService;

    @PostMapping
    public ResponseEntity<Author> addAuthor(@RequestBody Author author) {
        Author savedAuthor = authorService.addAuthor(author);
        return new ResponseEntity<>(savedAuthor, HttpStatus.OK); //savedAuthor we return it to be sure that is sent correctly in the database.
    //HttpStatus.OK, this is the happy scenario and the API is returned successfully.
    }
    //@RequestBody Author, this is the annotation that I will take this from frontend
    // ResponseEntity, this is to return a Json response
    //ResponseEntity<Author> addAuthor

    // The controller layer take the author from the front end.
    //Afterthat, you are going to send this to the service layer
    //And save data in the database by the repository layer


    @GetMapping
    public ResponseEntity<List<Author>> getAllAuthors(){
        List<Author> authors= authorService.getAllAuthors();
        return new ResponseEntity<>(authors, HttpStatus.OK);
    }

}




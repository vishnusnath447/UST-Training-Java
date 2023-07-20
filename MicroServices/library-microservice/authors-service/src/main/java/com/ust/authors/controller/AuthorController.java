package com.ust.authors.controller;

import com.ust.authors.domain.Author;
import com.ust.authors.domain.Book;
import com.ust.authors.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private List<Author> authors;

    @Autowired
    AuthorService authorService;

    public AuthorController(){
        this.authors = new ArrayList<>();
    }

    // POST /authors
    @PostMapping()
    public ResponseEntity<Author> saveAuthor(@RequestBody Author author){
        authors.add(author);
        return ResponseEntity.status(HttpStatus.CREATED).body(author);
    }
    // GET  /authors/{name}
    @GetMapping("/{name}")
    public ResponseEntity<Author> authorByName(@PathVariable String name){
        final var author = authors.stream().filter(author1 -> author1.getName().equals(name)).findFirst();
        if(author.isEmpty()){
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(author.get());
    }
    // GET  /authors/{name}/books
    @GetMapping("/{name}/books")
    public ResponseEntity<List<Book>> booksByAuthor(@PathVariable String name){
        final var books = authorService.findBooksByAuthor(name);
        if(books.isEmpty()){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(books);
    }
}

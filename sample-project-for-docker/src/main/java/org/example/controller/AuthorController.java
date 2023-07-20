package org.example.controller;

import org.example.domain.Author;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/author")
public class AuthorController {
    private List<Author> authorList;

    public AuthorController(){
        this.authorList = new ArrayList<>();
    }

    @PostMapping()
    public ResponseEntity<Author> saveAuthor(@RequestBody Author author){
        if(authorList.contains(author)){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        authorList.add(author);
        return ResponseEntity.status(HttpStatus.CREATED).body(author);
    }

    @GetMapping()
    public ResponseEntity<List<Author>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(authorList);
    }
}

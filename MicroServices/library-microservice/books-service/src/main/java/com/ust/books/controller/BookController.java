package com.ust.books.controller;

import com.ust.books.domain.Book;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private List<Book> books;

    public BookController() {
        this.books = new ArrayList<>();
    }

    @PostMapping()
    public ResponseEntity<Book> saveBook(@RequestBody Book book){
        books.add(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(book);
    }

    @GetMapping("/{title}")
    public ResponseEntity<Book> getByTitle(@PathVariable String title){
        final var book = books.stream().filter(book1 -> book1.getTitle().equals(title)).findFirst();
        if(book.isEmpty()){
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(book.get());
    }

    //url = /books/author/{authors}
    @GetMapping("/author/{author}")
    public ResponseEntity<List<Book>> getByAuthor(@PathVariable String author){
        final var book = books.stream().filter(book1 -> book1.getAuthor().equals(author)).toList();
        if(book.isEmpty()){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(book);
    }
}

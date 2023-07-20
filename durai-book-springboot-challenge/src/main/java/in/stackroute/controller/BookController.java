package in.stackroute.controller;

import in.stackroute.domain.Book;
import in.stackroute.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;
    @GetMapping("/language/{language}")
    public ResponseEntity<List<Book>> filterByLanguages(@PathVariable String language){
        List<Book> bookList = bookService.getAllBookBookByLanguage(language);
        if(bookList.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(bookList);
    }
}

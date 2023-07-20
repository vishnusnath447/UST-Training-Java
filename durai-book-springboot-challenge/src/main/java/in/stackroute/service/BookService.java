package in.stackroute.service;

import in.stackroute.domain.Book;
import in.stackroute.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;
    public List<Book> getAllBookBookByLanguage(String language){
        return bookRepository.findAllByLanguage(language);
    }
}

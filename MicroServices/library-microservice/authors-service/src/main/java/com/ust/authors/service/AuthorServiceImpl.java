package com.ust.authors.service;

import com.ust.authors.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private RestTemplate restTemplate;

    private String url = "http://BOOKS-SERVICE/books/author/{author}";

    @Override
    public List<Book> findBooksByAuthor(String author) {
        final var response = restTemplate.getForEntity(url, Book[].class,author);
        return Arrays.asList(response.getBody());
    }
}

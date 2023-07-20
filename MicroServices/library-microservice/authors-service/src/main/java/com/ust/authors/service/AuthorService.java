package com.ust.authors.service;

import com.ust.authors.domain.Book;

import java.util.List;

public interface AuthorService {

    List<Book> findBooksByAuthor(String author);
}

package com.ust.books.service;

import com.ust.books.domain.Author;

import java.util.Optional;

public interface BookService {

    Optional<Author> findAuthorByName(String author);
}

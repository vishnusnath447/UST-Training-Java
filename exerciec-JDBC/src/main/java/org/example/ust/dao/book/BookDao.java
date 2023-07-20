package org.example.ust.dao.book;

import org.example.ust.dao.GenericDao;
import org.example.ust.domain.Author;
import org.example.ust.domain.Book;
import org.example.ust.dto.AuthorBook;

import java.util.Optional;

public interface BookDao extends GenericDao<Book,Integer> {
    Optional<AuthorBook> getAuthorDetails(Integer bookId);
}

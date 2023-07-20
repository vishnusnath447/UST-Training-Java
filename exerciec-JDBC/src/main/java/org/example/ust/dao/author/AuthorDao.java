package org.example.ust.dao.author;

import org.example.ust.dao.GenericDao;
import org.example.ust.domain.Author;

import java.util.List;

public interface AuthorDao extends GenericDao<Author, Integer> {
    List<Author> readAll();
}

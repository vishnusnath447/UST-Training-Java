package org.example.ust.dao;

import java.util.Optional;

public interface GenericDao<T, E> {
    int update(T object);
    int delete(E id);
    int create(T object);
    Optional<T> read(E id);
}

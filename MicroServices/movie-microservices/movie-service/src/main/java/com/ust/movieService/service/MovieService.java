package com.ust.movieService.service;

import com.ust.movieService.domain.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {

    Movie create(Movie movie);

    Optional<Movie> findById(int id);

    Optional<Movie> findByTitle(String title);

    Movie update(Movie movie);

    void delete(int id);

    List<Movie> findAll();

    Optional<Movie> getByIdOrTitle(int id, String title);
}

package com.ust.movieService.repository;

import com.ust.movieService.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie,Integer> {
    Optional<Movie> findByTitle(String title);
    Optional<Movie> findByIdOrTitle(int id, String title);
}

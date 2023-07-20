package com.ust.movieService.service;

import com.ust.movieService.domain.Movie;
import com.ust.movieService.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService{
    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Movie create(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Optional<Movie> findById(int id) {
        return movieRepository.findById(id);
    }

    @Override
    public Optional<Movie> findByTitle(String title) {
        return movieRepository.findByTitle(title);
    }

    @Override
    public Movie update(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public void delete(int id) {
        movieRepository.deleteById(id);
    }

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    public Optional<Movie> getByIdOrTitle(int id, String title) {
        return movieRepository.findByIdOrTitle(id,title);
    }

}

package com.ust.movieService.controller;

import com.ust.movieService.domain.Movie;
import com.ust.movieService.dto.MovieDto;
import com.ust.movieService.exception.MovieAlreadyExistsException;
import com.ust.movieService.exception.MovieNotFoundException;
import com.ust.movieService.service.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

    private final MovieService movieService;

    private Logger logger = LoggerFactory.getLogger(MovieController.class);

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    // POST
    @PostMapping
    public ResponseEntity<MovieDto> createMovie(@Valid @RequestBody MovieDto movieDto) {
        logger.info("createMovie: Creating movie with title {}", movieDto.title());
        movieService.getByIdOrTitle(movieDto.id(), movieDto.title())
                .ifPresent(movie -> {
                    logger.error("createMovie: Movie with id {} or title {} already exists", movieDto.id(), movieDto.title());
                    throw new MovieAlreadyExistsException(
                            String.format("Movie with id %d or title %s already exists", movieDto.id(), movieDto.title()),
                            ServletUriComponentsBuilder.fromCurrentRequest().toUriString()
                    );
                });
        Movie movie = movieService.create(toEntity(movieDto));
        return ResponseEntity.created(
                ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(movie.getId()).toUri()
        ).body(toDto(movie));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDto> getMovie(@PathVariable("id") int id) {
        logger.info("getMovie: Fetching movie with id {}", id);
        var optional = movieService.findById(id);
        if (optional.isEmpty()) {
            logger.error("getMovie: Movie with id {} not found", id);
            throw new MovieNotFoundException(
                    String.format("Movie with id %d not found", id),
                    ServletUriComponentsBuilder.fromCurrentRequest().toUriString()
            );
        }
        return ResponseEntity.ok(toDto(optional.get()));
    }

    @GetMapping
    public ResponseEntity<List<MovieDto>> getAllMovies() {
        logger.info("getAllMovies: Fetching all movies");
        var list = movieService.findAll();
        if (list.isEmpty()) {
            logger.error("getAllMovies: No movies found");
            throw new MovieNotFoundException(
                    String.format("Movie with id %d not found"),
                    ServletUriComponentsBuilder.fromCurrentRequest().toUriString()
            );
        }
        return ResponseEntity.ok(list.stream().map(this::toDto).toList());

    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieDto> updateMovie(@PathVariable("id") int id, @RequestBody MovieDto movieDto) {
        logger.info("updateMovie: Updating movie with id {}", id);
        var optional = movieService.findById(id);
        if (optional.isEmpty()) {
            logger.error("updateMovie: Movie with id {} not found", id);
            throw new MovieNotFoundException(
                    String.format("Movie with id %d not found", id),
                    ServletUriComponentsBuilder.fromCurrentRequest().toUriString()
            );
        }
        Movie movie = optional.get();
        movie.setTitle(movieDto.title());
        movie = movieService.update(movie);
        return ResponseEntity.ok(toDto(movie));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable("id") int id) {
        logger.info("deleteMovie: Deleting movie with id {}", id);
        var optional = movieService.findById(id);
        if (optional.isEmpty()) {
            logger.error("deleteMovie: Movie with id {} not found", id);
            throw new MovieNotFoundException(
                    String.format("Movie with id %d not found", id),
                    ServletUriComponentsBuilder.fromCurrentRequest().toUriString()
            );
        }
        movieService.delete(optional.get().getId());
        return ResponseEntity.noContent().build();
    }

    private Movie toEntity(MovieDto dto) {
        return new Movie(dto.id(), dto.title());
    }

    private MovieDto toDto(Movie entity) {
        return new MovieDto(entity.getId(), entity.getTitle());
    }

}

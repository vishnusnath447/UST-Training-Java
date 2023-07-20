package com.ust.reviewService.service;

import com.ust.reviewService.dto.MovieDto;

import java.util.Optional;

public interface MovieService {
    Optional<MovieDto> getByMovieId(int id);
}

package com.ust.reviewService.service;

import com.ust.reviewService.domain.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewService {
    Optional<Review> getByMovieIdAndReviewer(String reviewer, int movieId);

    Review create(Review review);

    List<Review> getByReviewer(String email);

    List<Review> getByMovieId(int id);
}

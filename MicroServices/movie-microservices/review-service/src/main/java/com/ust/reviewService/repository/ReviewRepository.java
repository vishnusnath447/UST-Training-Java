package com.ust.reviewService.repository;

import com.ust.reviewService.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review,Integer> {
    Optional<Review> findByReviewerAndMovieId(String reviewer, int movieId);

    List<Review> findByReviewer(String email);
    List<Review> findByMovieId(int id);
}

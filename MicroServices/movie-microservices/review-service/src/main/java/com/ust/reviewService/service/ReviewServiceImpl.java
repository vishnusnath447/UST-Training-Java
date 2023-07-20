package com.ust.reviewService.service;

import com.ust.reviewService.domain.Review;
import com.ust.reviewService.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService{
    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Optional<Review> getByMovieIdAndReviewer(String reviewer, int movieId) {
        return reviewRepository.findByReviewerAndMovieId(reviewer,movieId);
    }

    @Override
    public Review create(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public List<Review> getByReviewer(String email) {
        return reviewRepository.findByReviewer(email);
    }

    @Override
    public List<Review> getByMovieId(int id) {
        return reviewRepository.findByMovieId(id);
    }
}

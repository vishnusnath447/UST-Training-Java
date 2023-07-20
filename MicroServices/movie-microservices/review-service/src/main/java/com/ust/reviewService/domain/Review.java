package com.ust.reviewService.domain;

import javax.persistence.*;

@Entity
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int reviewId;
    private String reviewer;
    private int movieId;
    private String review;

    public Review(){}

    public Review(int reviewId, String reviewer, int movieId, String review) {
        this.reviewId = reviewId;
        this.reviewer = reviewer;
        this.movieId = movieId;
        this.review = review;
    }

    public Review(String reviewer, int movieId, String review) {
        this.reviewer = reviewer;
        this.movieId = movieId;
        this.review = review;
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}

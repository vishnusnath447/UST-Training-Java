package com.ust.reviewService.controller;

import com.ust.reviewService.domain.Review;
import com.ust.reviewService.dto.ReviewDto;
import com.ust.reviewService.exception.ResourceNotFoundException;
import com.ust.reviewService.exception.ReviewNotFoundException;
import com.ust.reviewService.service.CustomerService;
import com.ust.reviewService.service.MovieService;
import com.ust.reviewService.service.ReviewService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/review")
public class ReviewController {
    private final ReviewService reviewService;
    private final CustomerService customerService;
    private final MovieService movieService;
    Logger logger = LoggerFactory.getLogger(ReviewController.class);

    public ReviewController(ReviewService reviewService, CustomerService customerService, MovieService movieService) {
        this.reviewService = reviewService;
        this.customerService = customerService;
        this.movieService = movieService;
    }

    @PostMapping()
    public ResponseEntity<ReviewDto> createReview(@Valid @RequestBody ReviewDto reviewDto){
        final var review = reviewService.getByMovieIdAndReviewer(reviewDto.reviewer(),reviewDto.movieId());
        if(review.isPresent()){
            logger.warn("Updating review because the review already exists");
            review.get().setReview(reviewDto.review());
            return ResponseEntity.created(
                    ServletUriComponentsBuilder.fromCurrentRequest().path("customer/{id}").buildAndExpand(reviewDto.reviewer()).toUri()
            ).body(toDto(reviewService.create(review.get())));
        }

        final var customer  = customerService.getByEmail(reviewDto.reviewer());
        final var movie = movieService.getByMovieId(reviewDto.movieId());
        if(customer.isEmpty() || movie.isEmpty()){
            logger.info("The resource which you gave is not present");
            throw new ResourceNotFoundException("The resource which you gave is not present",
                    ServletUriComponentsBuilder.fromCurrentRequestUri().toUriString());
        }
        logger.info("Saving the review");
        return ResponseEntity.created(
                ServletUriComponentsBuilder.fromCurrentRequest().path("customer/{id}").buildAndExpand(reviewDto.reviewer()).toUri()
        ).body(toDto(reviewService.create(toEntity(reviewDto))));
    }

    @GetMapping("/customer/{email}")
    public ResponseEntity<List<ReviewDto>> getReviewByCustomerId(@PathVariable String email){
        final var review = reviewService.getByReviewer(email);
        if(review.isEmpty()){
            logger.warn("Review not found");
            throw new ReviewNotFoundException(
                    String.format("Could not find a review with customer email: %d",email),
                    ServletUriComponentsBuilder.fromCurrentRequestUri().toUriString()
            );
        }
        logger.info("Review: "+review.toString());
        return ResponseEntity.status(HttpStatus.OK).body(review.stream().map(this::toDto).toList());
    }

    @GetMapping("/movie/{id}")
    public ResponseEntity<List<ReviewDto>> getReviewByMovieId(@PathVariable int id){
        final var review = reviewService.getByMovieId(id);
        if(review.isEmpty()){
            logger.warn("Review not found");
            throw new ReviewNotFoundException(
                    String.format("Could not find a review with movie id: %d",id),
                    ServletUriComponentsBuilder.fromCurrentRequestUri().toUriString()
            );
        }
        logger.info("Review: "+review.toString());
        return ResponseEntity.status(HttpStatus.OK).body(review.stream().map(this::toDto).toList());
    }

    public Review toEntity(ReviewDto reviewDto){
        return new Review(reviewDto.reviewer(), reviewDto.movieId(), reviewDto.review());
    }
    public ReviewDto toDto(Review review){
        return new ReviewDto(review.getReviewer(), review.getMovieId(), review.getReview());
    }
}

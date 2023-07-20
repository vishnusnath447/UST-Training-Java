package com.ust.reviewService.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public record ReviewDto(
        @NotNull(message = "CustomerId cannot be null")
        @NotEmpty(message = "CustomerId cannot be empty")
        String reviewer,
        int movieId,
        @NotNull(message = "Review cannot be null")
        @NotEmpty(message = "Review cannot be empty")
        String review) {
}

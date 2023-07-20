package com.ust.movieService.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public record MovieDto(
        int id,
        @NotNull(message = "Movie title cannot be null")
        @NotEmpty(message = "Movie title cannot be empty")
        @NotBlank(message = "Movie cannot be blank")
        String title
) {

}

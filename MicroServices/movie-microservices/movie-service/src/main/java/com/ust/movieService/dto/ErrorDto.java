package com.ust.movieService.dto;

import java.time.LocalDateTime;

public record ErrorDto(String message, LocalDateTime time, String uri, int status) {
}

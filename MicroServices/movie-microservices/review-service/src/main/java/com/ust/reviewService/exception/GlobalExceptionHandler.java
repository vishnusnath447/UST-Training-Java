package com.ust.reviewService.exception;

import com.ust.reviewService.dto.ErrorDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ReviewNotFoundException.class)
    public ResponseEntity<ErrorDto> handleReviewNotFoundException(ReviewNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body
                (new ErrorDto(ex.getMessage(), LocalDateTime.now(), ex.getUri(), HttpStatus.NOT_FOUND.value()));
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDto> handleResourceNotFoundException(ResourceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body
                (new ErrorDto(ex.getMessage(), LocalDateTime.now(), ex.getUri(), HttpStatus.BAD_REQUEST.value()));
    }

    @Override
    @ExceptionHandler(InvalidReviewDataException.class)
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return ResponseEntity.status(400).body(new ErrorDto(ex.getFieldError().getDefaultMessage(),
                LocalDateTime.now(), null, HttpStatus.BAD_REQUEST.value()));
    }
}

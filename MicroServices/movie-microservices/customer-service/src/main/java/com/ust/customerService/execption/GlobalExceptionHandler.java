package com.ust.customerService.execption;

import com.ust.customerService.dto.ErrorDto;
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
    @ExceptionHandler(CustomerAlreadyExistsException.class)
    public ResponseEntity<ErrorDto> handleCustomerAlreadyExistException(CustomerAlreadyExistsException e){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(
          new ErrorDto(e.getMessage(), LocalDateTime.now(),e.getUri(),HttpStatus.CONFLICT.value())
        );
    }

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<ErrorDto> handleCustomerNotFoundException(CustomerNotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
          new ErrorDto(e.getMessage(), LocalDateTime.now(),e.getUri(),HttpStatus.NOT_FOUND.value())
        );
    }

//    @ExceptionHandler(InvalidCustomerDataException.class)
//    public ResponseEntity<ErrorDto> handleInvalidMovieDataException(InvalidCustomerDataException ex) {
//        return ResponseEntity.status(400).body(new ErrorDto(ex.getMessage(),
//                LocalDateTime.now(), null, HttpStatus.BAD_REQUEST.value()));
//    }

    @Override
    @ExceptionHandler(InvalidCustomerDataException.class)
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return ResponseEntity.status(400).body(new ErrorDto(ex.getFieldError().getDefaultMessage(),
                LocalDateTime.now(), null, HttpStatus.BAD_REQUEST.value()));
    }

}

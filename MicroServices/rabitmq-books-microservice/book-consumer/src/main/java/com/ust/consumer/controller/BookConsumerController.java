package com.ust.consumer.controller;

import com.ust.consumer.dto.MessageDto;
import com.ust.consumer.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/consumer")
public class BookConsumerController {
    @Autowired
    private BookRepository bookRepository;

    @GetMapping()
    public ResponseEntity<List<MessageDto>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(bookRepository.findAll());
    }
}

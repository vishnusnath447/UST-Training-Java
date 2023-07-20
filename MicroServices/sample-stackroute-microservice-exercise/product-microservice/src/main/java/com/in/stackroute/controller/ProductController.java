package com.in.stackroute.controller;

import com.in.stackroute.domain.Product;
import com.in.stackroute.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Product>> getById(@PathVariable int id){
        return ResponseEntity.ok().body(productRepository.findById(id));
    }

}

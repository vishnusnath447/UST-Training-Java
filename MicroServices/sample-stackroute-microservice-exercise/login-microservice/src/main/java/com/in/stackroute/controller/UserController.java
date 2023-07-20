package com.in.stackroute.controller;

import com.in.stackroute.domain.User;
import com.in.stackroute.dto.CartDto;
import com.in.stackroute.dto.ResponseDto;
import com.in.stackroute.repository.UserRepository;
import com.in.stackroute.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductService productService;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user){
        final var result = userRepository.findByUsernameAndPassword(user.getUsername(),user.getPassword());
        if (result.isPresent()){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(userRepository.save(user));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user){
        final var result = userRepository.findByUsernameAndPassword(user.getUsername(),user.getPassword());
        if(result.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                String.format("You can now access http://localhost:8080/user/%s/addtocart",user.getUsername())
        );
    }

    @PostMapping("/{username}/addtocart")
    public ResponseEntity<List<ResponseDto>> addToCart(@PathVariable String username, @RequestBody CartDto cartDto){
        if(userRepository.findById(username).isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        ArrayList<ResponseDto> list = new ArrayList<>();
        for (int i:cartDto.productIds()){
            if(productService.getProduct(i).isEmpty()){
                return ResponseEntity.badRequest().build();
            }
            else {
                list.add(productService.getProduct(i).get());
            }
        }
        return ResponseEntity.ok().body(list);
    }
}

package com.ust.controller;

import com.ust.domain.Role;
import com.ust.domain.User;
import com.ust.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<User> loginAdmin(@RequestParam String uname, String psw){
        final var admin = userRepository.findByUsernameAndPassword(uname, psw);
        if(admin.isEmpty() || admin.get().getRole()!= Role.ADMIN){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(admin.get());
    }
}

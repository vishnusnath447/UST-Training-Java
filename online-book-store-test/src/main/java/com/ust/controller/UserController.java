package com.ust.controller;

import com.ust.domain.Role;
import com.ust.domain.User;
import com.ust.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    private int count = 2;

    @PostMapping("/login")
    public ResponseEntity<User> loginUser(@RequestParam String uname,String psw){
        final var user = userService.getUsernameAndPassword(uname, psw);
        if(user.isEmpty() || user.get().getRole() != Role.USER){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(user.get());
    }

    @PostMapping("/register")
    public ResponseEntity<User> addNewUser(@RequestParam String uname,String psw){
        if(uname==null || psw==null || uname.isEmpty() || psw.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        if(userService.getUserByUserName(uname).isPresent()){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        User user = new User(count,uname,psw,Role.USER);
        count++;
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveNewUser(user));
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        final var list = userService.getAllUsers().stream().filter(user->user.getRole()!=Role.ADMIN).collect(Collectors.toList());

        if(list.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }
}

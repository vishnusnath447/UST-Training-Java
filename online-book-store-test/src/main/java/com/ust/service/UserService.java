package com.ust.service;

import com.ust.domain.User;
import com.ust.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> getUsernameAndPassword(String uname, String pwd){
        return userRepository.findByUsernameAndPassword(uname,pwd);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserByUserName(String uname){
        return userRepository.findByUsername(uname);
    }

    public User saveNewUser(User user){
        return userRepository.save(user);
    }
}

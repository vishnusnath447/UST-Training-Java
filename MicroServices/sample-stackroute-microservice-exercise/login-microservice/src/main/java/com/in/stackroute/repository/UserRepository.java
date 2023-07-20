package com.in.stackroute.repository;

import com.in.stackroute.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,String> {
    public Optional<User> findByUsernameAndPassword(String username,String password);
}

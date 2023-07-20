package com.ust.repository;

import com.ust.domain.User;
import com.ust.execption.InvalidUserException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
//    @Query("SELECT u FROM User u WHERE u.username = ?1 AND u.password = ?2")
    Optional<User> findByUsernameAndPassword(String username,String password);
    Optional<User> findByUsername(String username);
}
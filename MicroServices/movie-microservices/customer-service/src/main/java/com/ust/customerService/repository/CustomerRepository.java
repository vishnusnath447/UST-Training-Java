package com.ust.customerService.repository;

import com.ust.customerService.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    Optional<Customer> findByEmail(String email);
    Optional<Customer> findByEmailAndPassword(String email,String password);

    Optional<Customer> findByIdOrEmail(int id,String email);
}
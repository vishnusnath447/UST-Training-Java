package com.ust.customerService.service;

import com.ust.customerService.domain.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    Optional<Customer> getById(int id);

    List<Customer> getAll();

    Customer create(Customer customer);

    Customer update(Customer customer);

    void remove(int id);

    Optional<Customer> getByEmail(String email);

    Optional<Customer> getByEmailAndPassword(String email, String password);

    Optional<Customer> getByIdOrEmail(int id,String email);
}

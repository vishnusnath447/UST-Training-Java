package com.ust.customerService.service;

import com.ust.customerService.domain.Customer;
import com.ust.customerService.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Optional<Customer> getById(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer create(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer update(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void remove(int id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Optional<Customer> getByEmail(String email) {
        return customerRepository.findByEmail(email);
    }

    @Override
    public Optional<Customer> getByEmailAndPassword(String email, String password) {
        return customerRepository.findByEmailAndPassword(email,password);
    }

    @Override
    public Optional<Customer> getByIdOrEmail(int id,String email) {
        return customerRepository.findByIdOrEmail(id,email);
    }
}

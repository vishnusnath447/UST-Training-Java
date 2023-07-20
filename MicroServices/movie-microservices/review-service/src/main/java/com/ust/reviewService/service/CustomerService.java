package com.ust.reviewService.service;

import com.ust.reviewService.dto.CustomerDto;

import java.util.Optional;

public interface CustomerService {
    Optional<CustomerDto> getByEmail(String reviewer);
}

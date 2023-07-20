package com.ust.reviewService.service;

import com.ust.reviewService.dto.CustomerDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{

    private String url = "http://CUSTOMER-SERVICE/api/v1/customer/email/{email}";
    private final RestTemplate restTemplate;

    public CustomerServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Optional<CustomerDto> getByEmail(String reviewer) {
        try{
            final var response = restTemplate.getForEntity(url,CustomerDto.class,reviewer);
            if(response.getStatusCode().is2xxSuccessful()){
                return Optional.ofNullable(response.getBody());
            }
            return Optional.empty();
        }
        catch (Exception e){
            return Optional.empty();
        }
    }
}

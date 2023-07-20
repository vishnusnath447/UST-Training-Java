package com.in.stackroute.service;

import com.in.stackroute.dto.ResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class ProductService {
    private String url = "http://localhost:8090/api/v1/product/{email}";
    private final RestTemplate restTemplate;

    public ProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Optional<ResponseDto> getProduct(int productId) {
        try{
            final var response = restTemplate.getForEntity(url,ResponseDto.class,productId);
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

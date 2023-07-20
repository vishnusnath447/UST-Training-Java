package com.ust.customerService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CustomerMicroService {
    public static void main(String[] args) {
        SpringApplication.run(CustomerMicroService.class,args);
    }
}
package com.ust.movieService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MovieMicroService {
    public static void main(String[] args) {
        SpringApplication.run(MovieMicroService.class,args);
    }
}
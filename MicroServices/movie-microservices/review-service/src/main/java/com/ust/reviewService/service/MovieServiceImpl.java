package com.ust.reviewService.service;

import com.ust.reviewService.dto.MovieDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService{

    private String url = "http://MOVIE-SERVICE/api/v1/movies/{id}";
    @Autowired
    private RestTemplate restTemplate;

//    public MovieServiceImpl(RestTemplate restTemplate) {
//        this.restTemplate = restTemplate;
//    }
    @Override
    public Optional<MovieDto> getByMovieId(int id) {
        try{
            final var response = restTemplate.getForEntity(url, MovieDto.class,id);
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

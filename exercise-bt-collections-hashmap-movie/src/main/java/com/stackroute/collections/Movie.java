package com.stackroute.collections;

import java.time.LocalDate;

/*
Movie class has four fields- movieId,movieName, genre and releaseDate
This class should be of Comparable type comparing movies based on releaseDate
 */
public class Movie implements Comparable<Movie>{

    private int movieId;
    private String movieName;
    private String genre;
    private LocalDate releaseDate;

    public Movie(int movieId, String movieName, String genre, LocalDate releaseDate) {
        this.movieId=movieId;
        this.movieName=movieName;
        this.genre=genre;
        this.releaseDate=releaseDate;
    }

    public int getMovieId() {
        return this.movieId;
    }

    public String getMovieName() {
        return this.movieName;
    }

    public String getGenre() {
        return this.genre;
    }

    public LocalDate getReleaseDate() {
        return this.releaseDate;
    }

    @Override
    public String toString() {
        return String.format("movieId=%s, movieName=%s, genre=%s, releaseDate=%s",
                this.getMovieId(),this.getMovieName(),this.getGenre(),this.getReleaseDate());
    }

    @Override
    public int compareTo(Movie o) {
        return releaseDate.compareTo(o.getReleaseDate());
    }
}

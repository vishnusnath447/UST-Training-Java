package com.stackroute.collections;

import java.time.LocalDate;
import java.util.*;

/*
This class contains a property called movieMap of type Map
This class contains methods for adding key-value pairs of Movie and its rating to HashMap and
various methods for accessing the keys and values based on some conditions
 */
public class MovieService {

    Map<Movie,Integer> movieMap;
    /**
     * Constructor to create movieMap as an empty  LinkedHashMap object
     */
    public MovieService() {
        movieMap = new LinkedHashMap<>();
    }

    /*
    Returns the movieMap object
     */
    public Map<Movie, Integer> getMovieMap() {
        return movieMap;
    }

    /*
    Add key-value pairs of Movie-Integer type and returns Set of Map.Entry
     */
    public Set<Map.Entry<Movie, Integer>> addKeyValuePairsToMap(Movie movie, Integer rating) {
        movieMap.put(movie,rating);
        return movieMap.entrySet();
    }

    /*
    Return Set of movie names having rating greater than or equal to given rating
     */
    public List<String> getHigherRatedMovieNames(int rating) {
        List<String> resultList = new ArrayList<>();
        for(Map.Entry<Movie,Integer> entry : movieMap.entrySet()){
            if(entry.getValue()>=rating){
                resultList.add(entry.getKey().getMovieName());
            }
        }
        return resultList;
    }

    /*
    Return Set of movie names belonging to specific genre
     */
    public List<String> getMovieNamesOfSpecificGenre(String genre) {
        List<String> resultList = new ArrayList<>();
        for(Map.Entry<Movie,Integer> entry : movieMap.entrySet()){
            if(genre.equals(entry.getKey().getGenre())){
                resultList.add(entry.getKey().getMovieName());
            }
        }
        return resultList;
    }

   /*
   Return Set of movie names which are released after Specific releaseDate and having rating less than or equal to 3
    */

    public List<String> getMovieNamesReleasedAfterSpecificDateAndRatingLesserThanThree(LocalDate releaseDate) {
        List<String> resultList = new ArrayList<>();
        for (Map.Entry<Movie,Integer> entry : movieMap.entrySet()){
            if((entry.getKey().getReleaseDate().compareTo(releaseDate) > 1) && (entry.getValue() <= 3)){
                resultList.add(entry.getKey().getMovieName());
            }
        }
        return resultList;
    }

    /*
    Return set of movies sorted by release dates in ascending order.
    Hint: Use TreeMap
     */
    public List<Movie> getSortedMovieListByReleaseDate() {
        Map<Movie,Integer> sortMap = new TreeMap<>();
        for (Map.Entry<Movie,Integer> entry:movieMap.entrySet()) {
            sortMap.put(entry.getKey(),entry.getValue());
        }
        List<Movie> resultList = new ArrayList<>(sortMap.keySet());
        return resultList;
    }

    /*
   Return set of movies sorted by rating.
   Hint: Use Comparator and LinkedHashMap
    */
    public Map<Movie, Integer> getSortedMovieListByRating() {
        List list = new LinkedList(movieMap.entrySet());

        Collections.sort(list, new Comparator<>() {
            @Override
            public int compare(Object o1,Object o2){
                return ((Comparable<Object>)((Map.Entry)(o1)).getValue()).compareTo(((Map.Entry)(o2)).getValue());
            }
        });

        HashMap resultMap = new LinkedHashMap();
        Iterator it = list.iterator();
        while(it.hasNext()){
            Map.Entry entry = (Map.Entry) it.next();
            resultMap.put(entry.getKey(), entry.getValue());
        }
        return resultMap;
    }
}

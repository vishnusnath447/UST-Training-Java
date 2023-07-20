package com.stackroute.lamdbaexpression;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateFunctionalInterface {
    //write logic to find the values that starts with letter I in the given list
    public List<String> findPattern(List<String> list) {
        Predicate<String> predicate = s->s.startsWith("I");
        List<String> result = new ArrayList<>();
        for (String s : list){
            if(predicate.test(s) && !result.contains(s)){
                result.add(s);
            }
        }
        return result;
    }
}

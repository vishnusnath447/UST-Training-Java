package com.stackroute.streams;

import java.util.List;
import java.util.stream.Collectors;

public class StringFormat {

    //write logic to find the format for given list and return result
    public String findStringFormat(List<Integer> input) {
        if(input==null || input.size()==0){
            return "Give proper input not empty list";
        }
        if(input.stream().anyMatch((num)->num<0)){
            return "Give proper input not negative values";
        }

        return input.stream().map((num)->( num%2==0?"even":"odd" )+num).
                collect(Collectors.joining(","));
    }
}

package com.stackroute.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


/**
 * Utility class for analyzing numbers in a List
 */
public class NumberUtility {

    /**
     * Returns count of even numbers in the given list of integers
     * Returns 0 if there are no even numbers or if the passed list is null
     */
    public long getEvenNumberCount(List<Integer> numbers) {
        if(numbers==null || numbers.size()==0) {
            return 0;
        }
        return numbers.stream().filter((num) -> num%2==0).count();
    }

    /**
     * Returns a list of even multiples of three from the given list of integers
     * Returns empty List, is the given list is null or empty
     */
    public List<Integer> getEvenMultiplesOfThree(List<Integer> numbers) {
        if(numbers==null || numbers.size()==0) {
            return new ArrayList<>();
        }
        return numbers.stream().filter((num) -> num%3==0).
                filter((num) -> num%2==0).toList();
    }

    /**
     * Returns maximum of odd numbers
     * Returns 0 if there are no odd numbers or if the passed list is null
     */
    public Integer getMaximumOfOddNumbers(List<Integer> numbers) {
        if(numbers==null){
            return 0;
        }
        /*
        return numbers.stream().filter((num)->num%2!=0).max((num1,num2)->num1.compareTo(num2))
                .stream().findFirst().orElse(0);
         */
        return numbers.stream().filter((num)->num%2!=0).max(Integer::compare).orElse(0);
    }
}
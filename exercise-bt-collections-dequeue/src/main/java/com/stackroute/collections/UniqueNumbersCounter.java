package com.stackroute.collections;

import java.util.*;

public class UniqueNumbersCounter {
    //write logic to find maximum unique numbers count from given array in the sub array of certain length
    public String findUniqueNumbersCount(int[] inputArray, int subArrayLength) {
        if(inputArray==null){
            return "Give proper input not null array";
        }
        if(inputArray.length==0){
            return "Give proper input not empty array";
        }
        if(inputArray.length<subArrayLength){
            return "Give proper input, sub array length exceeds array length";
        }
        if(subArrayLength<=0){
            return "Give proper input, sub array length can not be negative or zero";
        }

        Deque deque = new ArrayDeque();
        Set<Integer> set = new HashSet<>();
        int result=0;

        for(int i=0;i<inputArray.length;i++){
            deque.add(inputArray[i]);
            set.add(inputArray[i]);
            if(deque.size()==subArrayLength){
                int currentSize = set.size();
                if(currentSize>result){
                    result=currentSize;
                }
                int removed =(int) deque.pollFirst();
                if(!deque.contains(removed)){
                    set.remove(removed);
                }
            }
        }
       return "Count of Unique Numbers is "+result;
    }
}

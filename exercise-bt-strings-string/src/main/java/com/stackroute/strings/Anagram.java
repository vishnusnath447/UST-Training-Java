package com.stackroute.strings;

import java.util.Arrays;

public class Anagram {
    //write logic to check given two phrases are anagrams or not and return result
    public String checkAnagrams(String phraseOne, String phraseTwo) {
        String result="";
        if(phraseOne.isEmpty() || phraseTwo.isEmpty()){
            return "Give proper input not empty phrases";
        }

        char[] string1 = phraseOne.toCharArray();
        char[] string2 = phraseTwo.toCharArray();

        Arrays.sort(string1);
        Arrays.sort(string2);

        if(Arrays.equals(string1,string2)){
            result = "Given phrases are anagrams";
        }
        else {
            result = "Given phrases are not anagrams";
        }
        return result;
    }
}

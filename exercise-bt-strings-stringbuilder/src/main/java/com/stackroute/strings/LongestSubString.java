package com.stackroute.strings;

public class LongestSubString {

    //write logic to find the longest substring that appears at both ends of a given string and return result
    public StringBuilder findLongestSubString(StringBuilder input) {
        StringBuilder result = new StringBuilder("");
        int subLength=0;
        String subString = "";
        if(input.isEmpty()){
            return new StringBuilder("Give proper input");
        }
        for(int i=0;i<=input.length()/2;i++){
            subString=subString+input.charAt(i);
            if(input.indexOf(subString,input.length()/2)!=-1){
                if(subString.length()>=subLength){
                    subLength=subString.length();
                    result.replace(0,subLength,subString);
                }
            }
        }
        if(input.charAt(input.length()-1)==subString.charAt(subLength-1)){
            return result;
        }
        else{
            return new StringBuilder("Longest substring is not present in the given StringBuilder");
        }
    }
}

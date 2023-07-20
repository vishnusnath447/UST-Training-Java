package com.stackroute.exercises;


public class StringParse {
    //Write logic to find the character from the sentence at specified location
    public char characterLocator(String sentence, String location){
        try{
            return sentence.charAt(Integer.parseInt(location));
        } catch(NumberFormatException exception){
            throw new NumberFormatException();
        } catch (StringIndexOutOfBoundsException exception){
            throw new StringIndexOutOfBoundsException();
        }
    }
}

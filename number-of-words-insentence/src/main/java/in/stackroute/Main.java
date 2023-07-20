package in.stackroute;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String sentence = "Java is used to create a wide variety of application";
        System.out.println("Sentence: "+sentence);
        System.out.println("No: Words: "+wordFrequency(sentence));
    }

    public static int wordFrequency(String sentence) {
        if(sentence.isEmpty()){
            return 0;
        }
        final var words = sentence.split(" ");
        return words.length;
    }
}
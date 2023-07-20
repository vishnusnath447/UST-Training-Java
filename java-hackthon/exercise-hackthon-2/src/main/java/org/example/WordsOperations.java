package org.example;

import java.util.ArrayList;

public class WordsOperations {
    public String lowerCase(String words) {
        return words.toLowerCase();
    }

    public String replaceAll(String words) {
        words = words.replace(",", " ");
        words = words.replace(":", " ");
        words = words.replace(".", " ");
        words = words.replace(";", " ");
        words = words.replace("-", " ");
        return words;
    }

    public ArrayList<String> spaceRemoval(ArrayList<String> strings) {
        boolean space = false;
        space = strings.remove("");
        while (space) {
            space = strings.remove("");
        }
        return strings;
    }
}

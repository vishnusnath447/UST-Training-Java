package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Sorting{
    ArrayList<Word> reverseOrder(ArrayList<Word> words) {
        Collections.sort(words, new Comparator<Word>() {
            @Override
            public int compare(Word o1, Word o2) {
                return o2.getWord().compareTo(o1.getWord());
            }
        });

        return words;
    }

    ArrayList<Word> showFrequentWords(ArrayList<Word> words) {
        Collections.sort(words, new Comparator<Word>() {
            @Override
            public int compare(Word o1, Word o2) {
                if (o2.getWordCount() > o1.getWordCount())
                    return 1;
                else if (o2.getWordCount() < o1.getWordCount())
                    return -1;
                else
                    return o1.getWord().compareTo(o2.getWord());
            }
        });
        return words;
    }
}

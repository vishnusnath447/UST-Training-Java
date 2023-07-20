package org.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        WordListOperations wordListOperations = new WordListOperations();
        Sorting sorting = new Sorting();
        String words = new FileReading().readFromFile();
        ArrayList<Word> wordArrayList = wordListOperations.fileFoundWordList(words);
        long currentMills = System.currentTimeMillis();

        System.out.println("\n....................................................");
        System.out.println("File Found Order: ");
        System.out.println("....................................................\n");
        wordListOperations.showWordList(wordArrayList);
        System.out.println("\n....................................................\n");
        System.out.println("MilliSecond needed to Execute: "+(System.currentTimeMillis()-currentMills));
        currentMills=System.currentTimeMillis();

        ArrayList<Word> wordList = wordListOperations.caseSensitiveList(words);
        ArrayList<Word> wordLowerCaseList = wordListOperations.lowerCaseWordList(words);
        System.out.println("\n....................................................");
        System.out.println("Sorted alphabetical order");
        System.out.println("....................................................\n");
        wordListOperations.showWordList(wordList);
        System.out.println("\n....................................................\n");
        System.out.println("MilliSecond needed to Execute: "+(System.currentTimeMillis()-currentMills));
        currentMills=System.currentTimeMillis();

        System.out.println("\n....................................................");
        System.out.println("Sorted lower case word list");
        System.out.println("....................................................\n");
        wordListOperations.showWordList(wordLowerCaseList);
        System.out.println("\n....................................................\n");
        System.out.println("MilliSecond needed to Execute: "+(System.currentTimeMillis()-currentMills));
        currentMills=System.currentTimeMillis();

        System.out.println("\n....................................................");
        System.out.println("Sorted Frequent Word count");
        System.out.println("....................................................\n");
        wordListOperations.showWordList(sorting.showFrequentWords(wordLowerCaseList));
        System.out.println("\n....................................................\n");
        System.out.println("MilliSecond needed to Execute: "+(System.currentTimeMillis()-currentMills));
        currentMills=System.currentTimeMillis();

        System.out.println("\n....................................................");
        System.out.println("Sorted Descending order of Word");
        System.out.println("....................................................\n");
        wordListOperations.showWordList(sorting.reverseOrder(wordLowerCaseList));
        System.out.println("....................................................\n");
        System.out.println("MilliSecond needed to Execute: "+(System.currentTimeMillis()-currentMills));
        currentMills=System.currentTimeMillis();
    }
}
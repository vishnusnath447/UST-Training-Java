package org.example;

import java.util.*;

public class WordListOperations {
    void showWordList(ArrayList<Word> words) {
        for (Word word : words) {
            System.out.println(word.getWord()+" , "+word.getWordCount());
        }
    }

    ArrayList<Word> toWordList(ArrayList<String> list) {

        ArrayList<Word> words = new ArrayList<Word>();
        TreeSet<String> wordSet = new TreeSet<String>();
        wordSet.addAll(list);
        for (String string : wordSet) {
            int count = Collections.frequency(list, string);
            words.add(new Word(string,count));
        }
        return words;
    }

    ArrayList<Word> toWordListNonSet(ArrayList<String> list) {

        ArrayList<Word> words = new ArrayList<Word>();
        for (String string : list) {
            int count = Collections.frequency(list, string);
            words.add(new Word(string,count));
        }
        return words;

    }

    ArrayList<Word> lowerCaseWordList(String words) {

        WordsOperations wordsOperations = new WordsOperations();
        ArrayList<String> stringList;
        ArrayList<Word> wordLowerCaseList = new ArrayList<Word>();
        String wordsLowerCase = wordsOperations.lowerCase(words);
        wordsLowerCase = wordsOperations.replaceAll(wordsLowerCase);
        stringList = wordsOperations.spaceRemoval
                (new ArrayList<String>(Arrays.asList(wordsLowerCase.split(" "))));
        wordLowerCaseList = toWordList(stringList);
        return wordLowerCaseList;
    }

    ArrayList<Word> fileFoundWordList(String words) {

        WordsOperations wordsOperations = new WordsOperations();
        ArrayList<String> stringList;
        ArrayList<Word> wordLowerCaseList = new ArrayList<Word>();
        words = wordsOperations.replaceAll(words);
        stringList = wordsOperations.spaceRemoval
                (new ArrayList<String>(Arrays.asList(words.split(" "))));
        wordLowerCaseList = toWordListNonSet(stringList);
        return wordLowerCaseList;
    }

    ArrayList<Word> caseSensitiveList(String words) {
        WordsOperations wM = new WordsOperations();
        ArrayList<String> stringList;
        ArrayList<Word> wordObjList = new ArrayList<Word>();
        words = wM.replaceAll(words);
        stringList = wM.spaceRemoval(new ArrayList<String>(Arrays.asList(words.split(" "))));
        wordObjList = toWordList(stringList);
        return wordObjList;
    }
}

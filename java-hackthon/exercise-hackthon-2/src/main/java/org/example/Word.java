package org.example;

public class Word {
    String word;
    int wordCount;

    public Word(String word, int wordCount) {
        this.word = word;
        this.wordCount = wordCount;
    }
    public Word(){}

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getWordCount() {
        return wordCount;
    }

    public void setWordCount(int wordCount) {
        this.wordCount = wordCount;
    }
}

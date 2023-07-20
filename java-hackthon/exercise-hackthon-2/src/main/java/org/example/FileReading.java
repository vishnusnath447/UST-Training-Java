package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileReading {
    File file;
    FileReading(){
        file = new File("data/daffodils.txt");
    }

    public String readFromFile(){
        String words="";
        try(FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader)){
            String temp =bufferedReader.readLine();
            while (temp!=null){
                words = words+temp;
                temp = bufferedReader.readLine();
            }
        }
        catch (IOException e){
            System.err.println(e);
        }
        return words;
    }
}

package com.stackroute.fileio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateLines {
    //write logic to read data from input.txt and  write result to output.txt
    public void removeDuplicateLines() throws IOException {
        Set<String> set = new HashSet<>();
        try(FileReader fileReader = new FileReader("input.txt")){
            try(BufferedReader bufferedReader = new BufferedReader(fileReader)){
                String line = bufferedReader.readLine();
                while(line!=null){
                    set.add(line);
                    line=bufferedReader.readLine();
                }
            }
        }

        try(FileWriter fileWriter = new FileWriter("output.txt")){
            for(String str:set){
                fileWriter.write(str+"\n");
            }
            fileWriter.flush();
        }
    }
}

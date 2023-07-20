package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {
    private String fileName;
    FileManager(String fileName){
        this.fileName=fileName;
    }
    public void writeToFile(String line){
        try(FileWriter fileWriter = new FileWriter(fileName,true)){
            fileWriter.write(line);
            fileWriter.flush();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public void readFromFile(){
        try(FileReader fileReader = new FileReader(fileName)){
            try (BufferedReader bufferedReader = new BufferedReader(fileReader)){
                String line = bufferedReader.readLine();
                int i=1;
                while (line!=null){
                    System.out.println(i+"-> "+line);
                    line = bufferedReader.readLine();
                    i++;
                }
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}

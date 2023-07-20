package in.stackroute.ust.domain;

import java.io.FileWriter;
import java.io.IOException;

public class FileManager {
    public void readFromFile(){}
    public void writeToFile(Item item){
        try(FileWriter fileWriter = new FileWriter("Inventory.txt",true)){
            fileWriter.write(item.toString());
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}

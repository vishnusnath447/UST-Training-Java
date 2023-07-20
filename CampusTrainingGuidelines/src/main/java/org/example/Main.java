package org.example;

public class Main {
    public static void main(String[] args) {
        FileManager fileManager = new FileManager("Guidlines.txt");

        fileManager.writeToFile("Be Punctual and prepared for class everyday\n");
        fileManager.writeToFile("Adhere to training session and break timings\n");
        fileManager.writeToFile("Dress appropriately and adhere to UST dress code policy\n");
        fileManager.writeToFile("Ask questions and seek clarification\n");
        fileManager.writeToFile("Show courtesy to the speaker and wait for your turn\n");
        fileManager.writeToFile("Training premises should be maintained neat and tidy\n");
        fileManager.writeToFile("Be mindful of UST property. Vandalism will lead to disciplinary action\n");
        fileManager.writeToFile("No food or beverages allowed outside of the designated areas\n");
        fileManager.writeToFile("Strictly no casual leaves allowed while in training\n");
        fileManager.writeToFile("Access to mobile phones are strictly prohibited in the training rooms\n");
        fileManager.writeToFile("Be respectful of your own personal space and of those around you\n");
        fileManager.writeToFile("Uphold UST Values\n");

        fileManager.readFromFile();
    }
}
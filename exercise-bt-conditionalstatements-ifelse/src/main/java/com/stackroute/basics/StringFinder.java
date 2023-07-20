package com.stackroute.basics;

import java.util.Scanner;

public class StringFinder {
    //Create Scanner object as instance variable
    Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        //Get three strings from the user
        String searchStr="";
        String firstStr="";
        String secondStr="";
        StringFinder stringFinder = new StringFinder();
        searchStr=stringFinder.getInput();
        firstStr=stringFinder.getInput();
        secondStr=stringFinder.getInput();
        stringFinder.closeScanner();
        stringFinder.displayResult(stringFinder.findString(searchStr,firstStr,secondStr));
    }

    public String getInput() {
        return scanner.nextLine();
    }

    public void displayResult(int result) {
        //displays the result
        switch(result){
            case -1:
                System.out.println("emptystringornull");
                break;
            case 0:
                System.out.println("notfound");
                break;
            case 1:
                System.out.println("foundasexpected");
                break;
        }
    }

    public int findString(String searchString, String firstString, String secondString) {
        if(secondString==null || firstString==null || searchString==null){
            return -1;
        }
        else
        if(searchString.isEmpty() || firstString.isEmpty() || secondString.isEmpty()){
            return -1;
        } else{
            int pos1 = searchString.indexOf(firstString);
            int pos2 = searchString.indexOf(secondString);
            if((pos1<pos2)&&(pos1!=-1)&&(pos2!=-1)){
                return 1;
            }
            else{
                return 0;
            }
        }
    }

    public void closeScanner() {
        scanner.close();
    }
}

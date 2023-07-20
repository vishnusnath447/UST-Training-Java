package com.stackroute.basics;


import java.util.Scanner;

public class NumberAverage {

    public static void main(String[] args) {
        new NumberAverage().getArrayValues();
    }

    //get the values of the array from the user
    public void getArrayValues() {
        Scanner scanner = new Scanner(System.in);
        int limit = scanner.nextInt();
        int[] array = new int[limit];
        for(int i=0;i<limit;i++){
            array[i]=scanner.nextInt();
        }
        System.out.println(findAverage(array));
    }

    //write here logic to calculate the average an array
    public String findAverage(int[] inputArray) {
        int flag=0;
        int sum=0;
        if(inputArray.length==0){
            return "Empty array";
        }
        for (int i:inputArray) {
            if(i>=0){
                sum=sum+i;
            }
            else {
                flag=1;
                break;
            }
        }
        if(flag==0){
            return "The average value is: "+sum/inputArray.length;
        }
        else{
            return "Give proper positive integer values";
        }
    }
}

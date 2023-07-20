package com.stackroute.basics;


import java.util.Scanner;

public class RectanglePerimeter {
    public static void main(String[] args) {
        new RectanglePerimeter().getValues();
    }

    //get user input from console
    public void getValues() {
        Scanner scanner = new Scanner(System.in);
        double length;
        double breadth;
        length=scanner.nextDouble();
        breadth=scanner.nextDouble();
        System.out.println(perimeterCalculator(length,breadth));
    }

    //write logic to find perimeter of rectangle here
    public double perimeterCalculator(double length, double breadth) {
        return 2*(length+breadth);
    }
}

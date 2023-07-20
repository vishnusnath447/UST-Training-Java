package org.example;

public class Main {
    public static void main(String[] args) {
        calculate<String,String,String> add = (a,b) -> a+b;
        System.out.println(add.calculate("20","10"));

        calculate<Integer,Integer,Integer> sub = (a,b) -> a-b;
        System.out.println(sub.calculate(20,10));

        Greeting frgreet = ()-> System.out.println("Bonjour");
        Greeting krgreet = ()-> System.out.println("Namskaram");

        frgreet.greet();
    }
}
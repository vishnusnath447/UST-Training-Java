package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Arithmetics {
    public int add(int a, int b){
        return a+b;
    }
    public int sub(int a, int b){
        return a-b;
    }
    public int div(int a, int b){
        if(b==0){
            throw new ArithmeticException();
        }
        return a/b;
    }
    public int mul(int a, int b){
        return a*b;
    }

    public List<Integer> printEven(List<Integer> numbers){
        return numbers.stream().filter((n)->n%2==0).toList();
    }

    public void testFn(int ...var){
        Arrays.stream(var).forEach(System.out::println);
        System.out.println("..............................");
        System.out.println(Arrays.stream(var).max().getAsInt());

    }

}

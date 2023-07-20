package org.example;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        /*
        Stream<Integer> streamInteger = Stream.of(1,2,3,4,5,6,7,8,9);

        Function<Integer,String> function = (num)->num.toString();

        streamInteger.map(function).forEach((s)-> System.out.println(s));
         */

        List<String> list = new ArrayList<>();
        list.add("Vishnu");
        list.add("Aswati");
        list.add("Anu");
        list.add("Swathi");
        list.add("Anagha");
        list.add("Anamika");

        System.out.println( list.stream().filter(s->s.matches("..a.*")).collect(Collectors.toList()));
    }
}
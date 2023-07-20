package org.example;

import org.example.shapes.Color;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context;
        context = new ClassPathXmlApplicationContext("spring.xml");

        Color color = context.getBean("color", Color.class);
        Color white = context.getBean("white",Color.class);
        System.out.println(white.getColor());
        color.setColor("Blue");
        System.out.println(color.getColor());

        // or

//        try(AbstractApplicationContext abstractContext = new ClassPathXmlApplicationContext("spring.xml")){
//            Color color1 = abstractContext.getBean("color", Color.class);
//            System.out.println(color1.getColor());
//            color1.setColor("BLUE");
//            System.out.println(color1.getColor());
//        }catch (Exception e){
//            System.err.println(e.getMessage());
//        }
    }
}
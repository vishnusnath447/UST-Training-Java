package com.stackroute;

import com.stackroute.Domain.Movie;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Movie beanA = context.getBean("movie", Movie.class);
        Movie beanB = context.getBean("movie", Movie.class);
        System.out.println("BeanA: => "+beanA);
        System.out.println("BeanB: => "+beanB);
        System.out.println("beanA==beanB: "+(beanA==beanB));

        Movie movieA = context.getBean("movieA", Movie.class);
        Movie movieB = context.getBean("movieB", Movie.class);
        System.out.println("MovieA: "+movieA+"\n"+"MovieA: "+movieB);
    }
}
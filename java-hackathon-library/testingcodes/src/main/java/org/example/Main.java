package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String str = "hai hello hai how are  are are hai you";
        String result = "";

        for(int i=0;i<str.length()/2;i++){
            result = result + str.charAt(i);
        }
        result = result + " new ";
        for(int i=str.length()/2;i<str.length();i++){
            result = result + str.charAt(i);
        }
        System.out.println(result);


        String result2="";
        result2=str.substring(0,str.length()/2);
        result2= result2+" new ";
        result2=result2+str.substring(str.length()/2,str.length());
        System.out.println(result2);

        List<String> list = new ArrayList<>();
        list.toArray();

        String[] str1 = {"gss","sss","ddd"};

        Arrays.asList(str1);

        int[] arr = {1,3,4,5};
        System.out.println(fun(1999,arr));
    }

    public static int fun(int n , int[] d){
        int flag=0,count=0,result=0;
        while(flag!=1){
            List<Integer> list = new ArrayList<>();
            int m=n;
            while (m>0){
                list.add(m%10);
                m=m/10;
            }
            for(int i=0;i<d.length;i++){
                if(list.contains(d[i])){
                    count++;
                }
            }
            if(count==0) {
                result = n;
                break;
            }
            n++;
            count=0;
        }
        return result;
    }
}
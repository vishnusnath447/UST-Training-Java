package com.stackroute.exercises;


import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StringSort {

    //write here logic to sort a string List
    public String stringSorter(List<String> stringList, String sortingOrder) {
        String result = "";
        int flag=0;
        if(stringList == null || stringList.isEmpty() || sortingOrder == null ||
                sortingOrder.isEmpty() || sortingOrder.equals(" ")){
            result="Given stringList or sortingOrder is empty, null or blank space";
            flag=1;
        } else if(stringList.size() == 1){
            result="The list contains only one value";
            flag=1;
        } else if(!sortingOrder.equalsIgnoreCase("asc") && ! sortingOrder.equalsIgnoreCase("desc")){
            result = "No sorting order present for given string '"+sortingOrder+
                    "' , 'asc' for ascending order sort and 'desc' for descending order sort";
            flag=1;
        }
        if(stringList!=null && (stringList.contains(" ") || stringList.contains(""))){
            result="The list contains an empty or blank space value";
            flag=1;
        }

        if(flag==0){
            if(sortingOrder.equals("desc")){
                stringList.sort(new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        return o2.compareTo(o1);
                    }
                });
                result = stringList.toString();
            }
            else {
                stringList.sort(new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        return o1.compareTo(o2);
                    }
                });
                result = stringList.toString();
            }
        }
        return result;
    }
}

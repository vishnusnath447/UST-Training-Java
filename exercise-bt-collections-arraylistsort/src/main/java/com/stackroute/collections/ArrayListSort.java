package com.stackroute.collections;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ArrayListSort {
    //write logic to sort given list in descending order
    public ArrayList<BigInteger> arrayListSortDesc(ArrayList<BigInteger> list) {
        ListComparator comparator = new ListComparator();
        list.sort(comparator);
        return list;
    }
    class ListComparator implements Comparator<BigInteger> {
        @Override
        public int compare(BigInteger b1,BigInteger b2){
            return b2.compareTo(b1);
        }
    }

}

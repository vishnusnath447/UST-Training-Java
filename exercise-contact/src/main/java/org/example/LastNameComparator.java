package org.example;

import java.util.Comparator;

public class LastNameComparator implements Comparator<Contact> {
    @Override
    public int compare(Contact o1, Contact o2) {
        return o1.getLastName().toLowerCase().compareTo(o2.getLastName().toLowerCase());
    }
}

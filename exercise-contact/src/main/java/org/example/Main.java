package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Contact c1  = new Contact("Vishnu","S Nath","8075124306");
        Contact c2  = new Contact("Meera","R","8078263353");
        Contact c3  = new Contact("Anu","Polly","7034674969");
        Contact c4  = new Contact("","S Nath","8075124306");
        Contact c5  = new Contact("Meera","","8078263353");
        Contact c6  = new Contact("Anu","Polly","");

        List<Contact> contactList= new ArrayList<>();

        ListContactService listContactService = new ListContactService(contactList);
        listContactService.addContact(c1);
        listContactService.addContact(c2);
        listContactService.addContact(c3);
        listContactService.addContact(c4);
        listContactService.addContact(c5);
        listContactService.addContact(c6);
        listContactService.print();

        System.out.println("\n...................................................................");
        listContactService.displayContact(SortOption.FIRST_NAME);
        System.out.println("...................................................................");
        System.out.println("\n...................................................................");
        listContactService.displayContact(SortOption.LAST_NAME);
        System.out.println("...................................................................");
        System.out.println("\n...................................................................");
        listContactService.displayContact(SortOption.PHONE_NUMBER);
        System.out.println("...................................................................");

        listContactService.deleteContact("Vishnu","S Nath");

        listContactService.print();

        System.out.println("...................................................................");
        System.out.println(listContactService.searchContact("Anu","Polly"));
        System.out.println("...................................................................");

        Contact c7  = new Contact("Meera","R","0000000000");

        listContactService.updateContact(c7);
        System.out.println("\n...................................................................");
        listContactService.print();

    }
}
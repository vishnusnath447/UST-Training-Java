package org.example;

import java.util.Collections;
import java.util.List;

public class ListContactService implements ContactService{

    List<Contact> contactList;
    public ListContactService(List<Contact> contactList){
        this.contactList = contactList;
    }
    @Override
    public void addContact(Contact contact) {
        if(!Validator.validate(contact,this)){
            System.err.println("Invalid Contact Entries.");
            return;
        }
        contactList.add(contact);
    }

    @Override
    public void deleteContact(String firstName, String lastName) {
        contactList.remove(searchContact(firstName,lastName));
    }

    @Override
    public void displayContact(SortOption sortOption) {
        if(sortOption==null || sortOption.equals(SortOption.FIRST_NAME)){
            Collections.sort(contactList);
        }
        else if (sortOption.equals(SortOption.LAST_NAME)) {
            Collections.sort(contactList,new LastNameComparator());
        }
        else if (sortOption.equals(SortOption.PHONE_NUMBER)) {
            Collections.sort(contactList,new PhoneNumberComparator());
        }
        print();
    }

    @Override
    public Contact searchContact(String firstName, String lastName) {
        for (Contact contact:contactList) {
            if(contact.getFirstName().equalsIgnoreCase(firstName)
                    && contact.getLastName().equalsIgnoreCase(lastName)){
                return contact;
            }
        }
        return null;
    }

    @Override
    public void updateContact(Contact contact) {
        if(!Validator.validate(contact)){
            System.err.println("Invalid Contact Entries.");
            return;
        }
        System.out.println(contactList.set(contactList.indexOf(searchContact(contact.getFirstName(),
                        contact.getLastName())),contact));
    }

    @Override
    public void print() {
        for(Contact contact:contactList){
            System.out.printf("[ %s, %s, %s ]\n",contact.getFirstName(),
                    contact.getLastName(),contact.getPhoneNumber());
        }
    }
}

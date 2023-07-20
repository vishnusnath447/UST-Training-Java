package org.example;

import java.util.List;

public class Validator {
    private Validator(){}

    public static boolean validate(Contact contact,ContactService contactService) {
        return isNameValid(contact.getFirstName())
                && isNameValid(contact.getLastName())
                && isPhoneNumberValid(contact.getPhoneNumber())
                && isContactPresent(contact,contactService);
    }

    private static boolean isContactPresent(Contact contact,ContactService contactService) {
        if(contactService.searchContact(contact.getFirstName(),contact.getLastName())==null){
            return true;
        }
        return false;
    }

    private static boolean isPhoneNumberValid(String phoneNumber) {
        if(phoneNumber == null || phoneNumber.isEmpty() || !phoneNumber.matches("[0-9]{10}+")){
            return false;
        }
        return true;
    }

    private static boolean isNameValid(String name) {
        if(name == null || name.isEmpty() || !name.matches("[a-zA-Z ]+")){
            return false;
        }
        return true;
    }

    public static boolean validate(Contact contact)
    {
        return isNameValid(contact.getFirstName())
                && isNameValid(contact.getLastName())
                && isPhoneNumberValid(contact.getPhoneNumber());
    }
}

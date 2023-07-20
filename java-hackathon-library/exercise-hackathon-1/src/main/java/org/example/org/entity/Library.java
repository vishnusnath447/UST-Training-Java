package org.example.org.entity;

import java.util.Arrays;

public class Library {
    private String libraryName;
    private String libraryRegNo;
    private Address address;
    private Book[] books;

    public Library(){}
    public Library(String libraryName, String libraryRegNo, Address address,Book[] books) {
        this.libraryName = libraryName;
        this.libraryRegNo = libraryRegNo;
        this.address = address;
        this.books=books;
    }

    public Book[] getBooks() {
        return books;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }

    public String getLibraryName() {
        return libraryName;
    }

    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
    }

    public String getLibraryRegNo() {
        return libraryRegNo;
    }

    public void setLibraryRegNo(String libraryRegNo) {
        this.libraryRegNo = libraryRegNo;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Library{" +
                "libraryName='" + libraryName + '\'' +
                ", libraryRegNo='" + libraryRegNo + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    void lendBooks(int bookIsbnNo){
        Arrays.stream(books).dropWhile(b->b.getBookIsbnNo()==bookIsbnNo);
        System.out.println("Book Given");
    }
    void collectDue(int amount){
        System.out.println("Your Total Amount is : "+amount);
    }
}

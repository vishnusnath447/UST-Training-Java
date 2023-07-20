package org.example.domain;


public class Author {
    private int id;
    private String fName;
    private String lName;
    private int noBooks;

    public Author(){}

    public Author(int id, String fName, String lName, int noBooks) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.noBooks = noBooks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public int getNoBooks() {
        return noBooks;
    }

    public void setNoBooks(int noBooks) {
        this.noBooks = noBooks;
    }
}

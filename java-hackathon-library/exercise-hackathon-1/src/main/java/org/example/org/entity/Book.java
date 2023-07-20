package org.example.org.entity;

public class Book {
    private int bookIsbnNo;
    private String author;
    private String  publisher;

    public Book(int bookIsbnNo, String author, String publisher) {
        this.bookIsbnNo = bookIsbnNo;
        this.author = author;
        this.publisher = publisher;
    }

    public Book() {
    }

    public int getBookIsbnNo() {
        return bookIsbnNo;
    }

    public void setBookIsbnNo(int bookIsbnNo) {
        this.bookIsbnNo = bookIsbnNo;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookIsbnNo=" + bookIsbnNo +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                '}';
    }
}

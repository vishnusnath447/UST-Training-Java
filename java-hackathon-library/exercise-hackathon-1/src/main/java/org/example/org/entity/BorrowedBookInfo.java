package org.example.org.entity;

import java.time.LocalDate;

public class BorrowedBookInfo {
    private Book book;
    private LocalDate borrowedDate;
    private LocalDate dueDate;

    public BorrowedBookInfo(){}
    public BorrowedBookInfo(Book book, LocalDate borrowedDate, LocalDate dueDate) {
        this.book = book;
        this.borrowedDate = borrowedDate;
        this.dueDate = dueDate;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LocalDate getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(LocalDate borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "BorrowedBookInfo{" +
                "book=" + book +
                ", borrowedDate=" + borrowedDate +
                ", dueDate=" + dueDate +
                '}';
    }
}

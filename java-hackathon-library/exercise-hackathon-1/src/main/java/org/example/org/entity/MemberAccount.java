package org.example.org.entity;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class MemberAccount {
    private int accountNo;
    private List<BorrowedBookInfo> borrowed;

    public MemberAccount(int accountNo, List<BorrowedBookInfo> borrowed) {
        this.accountNo = accountNo;
        this.borrowed = borrowed;
    }

    public MemberAccount() {
    }

    public void setBorrowed(List<BorrowedBookInfo> borrowed) {
        this.borrowed = borrowed;
    }

    public int getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }


    void borrowBook(int bookIsbnNo,Library library){
        Book book = Arrays.stream(library.getBooks()).filter(b->b.getBookIsbnNo()==bookIsbnNo).findFirst().get();
        BorrowedBookInfo borrowedBookInfo = new BorrowedBookInfo(book, LocalDate.now(),
                LocalDate.now().plusWeeks(3));
        if(borrowed.size() < 5){
            this.borrowed.add(borrowedBookInfo);
            System.out.println("Successfully borrowed");
        }
    }
    void returnBook(int bookIsbnNo,Library library){
        BorrowedBookInfo borrowedBookInfo = borrowed.stream().
                filter(b->b.getBook().getBookIsbnNo()==bookIsbnNo).findFirst().get();
        if(LocalDate.now().isAfter(borrowedBookInfo.getDueDate())){
            payDues(library,100);
            System.out.println("Successfully paid");
        }
    }
    void payDues(Library library,int amount){
        library.collectDue(amount);
    }
}

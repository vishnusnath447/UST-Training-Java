package org.example;

import org.example.ust.dao.author.AuthorDaoMySqlImpl;
import org.example.ust.dao.book.BookDaoMySqlImpl;
import org.example.ust.domain.Author;
import org.example.ust.domain.Book;
import org.example.ust.dto.AuthorBook;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {

    static void displayBookWithAuthor(){
        BookDaoMySqlImpl bookDaoMySql = new BookDaoMySqlImpl();
        Optional<AuthorBook> authorBook = bookDaoMySql.getAuthorDetails(1);
        if(authorBook == null){
            System.out.println("NULL");
            return;
        }
        System.out.println(authorBook.get().authorName()+" wrote the book: "+authorBook.get().bookTitle());
    }

    static void readAllAuthor(){
        List<Author> authorList = new ArrayList<>();
        AuthorDaoMySqlImpl authorDaoMySql = new AuthorDaoMySqlImpl();
        authorList=authorDaoMySql.readAll();
        for (Author author : authorList){
            System.out.printf("%s\t%s\t%s\t%s\n",author.authorId(),author.authorName(),
                    author.authorEmail(),author.joinDate());
        }
    }

    static void readAuthors(){
        AuthorDaoMySqlImpl authorDaoMySql = new AuthorDaoMySqlImpl();
        Optional<Author> author = authorDaoMySql.read(100);
        if(author == null){
            System.err.println("NULL");
            return;
        }
        System.out.printf("""
                \nAuthor ID: %s
                Author Name: %s
                Author Email: %s
                Author Join Date: %s
                """,author.get().authorId(),author.get().authorName(),
                author.get().authorEmail(),author.get().joinDate());
    }

    static void readBooks(){
        BookDaoMySqlImpl bookDaoMySql = new BookDaoMySqlImpl();
        Optional<Book> book = bookDaoMySql.read(1);
        if(book == null){
            System.err.println("NULL");
            return;
        }
        System.out.printf("""
                \nBook ID: %s
                Book Title: %s
                Author Id: %s
                """,book.get().bookId(),book.get().bookTitle(),book.get().authorId());
    }

    public static void main(String[] args) {
        readAllAuthor();
    }
}
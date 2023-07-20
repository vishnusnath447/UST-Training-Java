package com.ust.consumer.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "message")
public class MessageDto implements Serializable {

    @Id
    private String name;
    private List<String> bookList;

    public MessageDto(){}

    public MessageDto(String name, List<String> bookList) {
        this.name = name;
        this.bookList = bookList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getBookList() {
        return bookList;
    }

    public void setBookList(List<String> bookList) {
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        return "MessageDto{" +
                "name='" + name + '\'' +
                ", bookList=" + bookList +
                '}';
    }
}

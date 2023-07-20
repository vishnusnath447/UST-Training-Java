package in.stackroute.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "books")
public class Book {
    @Id
    private int bookId;

    private String bookName;
    private String language;
    private double price;
}

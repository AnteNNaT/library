package ru.geekbrains.library.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="issued_books")
public class IssuedBooks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="ID_READER")
    private Reader reader;

    @ManyToOne
    @JoinColumn(name="ID_BOOK")
    private  Book book;

    private Date issueDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }
}

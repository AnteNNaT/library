package ru.geekbrains.library.entity;

import javax.persistence.*;

@Entity
@Table(name="book_storage")
public class BookStorage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name="BOOK_ID")
    private Book book;

    private int qty;
    private int issuedQty;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getIssuedQty() {
        return issuedQty;
    }

    public void setIssuedQty(int issuedQty) {
        this.issuedQty = issuedQty;
    }
}

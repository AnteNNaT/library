package ru.geekbrains.library.model;

import java.io.Serializable;

public class IssuedBooksRequest implements Serializable {

    private Long readerId;
    private Long bookID;

    public Long getReaderId() {
        return readerId;
    }

    public void setReaderId(Long readerId) {
        this.readerId = readerId;
    }

    public Long getBookID() {
        return bookID;
    }

    public void setBookID(Long bookID) {
        this.bookID = bookID;
    }

    @Override
    public String toString() {
        return "IssuedBooksRequest{" +
                "ReaderId=" + readerId +
                ", BookID=" + bookID +
                '}';
    }
}

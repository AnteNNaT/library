package ru.geekbrains.library.model;

import ru.geekbrains.library.entity.Book;

import java.io.Serializable;
import java.util.List;

public class ListBooks implements Serializable {

List<Book> books;

    public ListBooks(List<Book> books) {
        this.books = books;
    }
    public ListBooks() {
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}

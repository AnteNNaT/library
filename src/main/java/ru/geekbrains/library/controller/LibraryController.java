package ru.geekbrains.library.controller;

import org.springframework.web.bind.annotation.*;
import ru.geekbrains.library.entity.Book;
import ru.geekbrains.library.entity.IssuedBooks;
import ru.geekbrains.library.entity.Reader;
import ru.geekbrains.library.model.IssuedBooksRequest;
import ru.geekbrains.library.service.BooksService;

import java.util.List;

@RestController
public class LibraryController {

    public final BooksService booksService;

    public LibraryController(BooksService booksService) {
        this.booksService = booksService;
    }

    @GetMapping("/authors/{author_id}/books")
    public List<Book> getAllBooksByAuthor(@PathVariable Long author_id) {
        return booksService.findAllBooksByAuthorId(author_id);
    }

    @GetMapping("/readers/{reader_id}/books")
    public List<Book> getAllBooksByReader(@PathVariable Long reader_id) {
        return booksService.findAllBooksByReaderId(reader_id);
    }

    @GetMapping("/authors/{author_id}/readers")
    public List<Reader> getAllReadersByAuthor(@PathVariable Long author_id) {
        return booksService.findAllReadersByAuthorId(author_id);
    }

    @PostMapping("/issuedBooks")
    public Long giveOutBooks(@RequestBody IssuedBooksRequest request) {
        IssuedBooks issuedBooks = new IssuedBooks();
        issuedBooks.setBook(booksService.findBookById(request.getBookID()));
        issuedBooks.setReader(booksService.findReaderById(request.getReaderId()));
        issuedBooks.setIssueDate(new java.sql.Timestamp(System.currentTimeMillis()));
        issuedBooks = booksService.saveIssuedBooks(issuedBooks);
        return issuedBooks.getId();
    }

    @DeleteMapping("/issuedBooks/return")
    public void returnBooks(@RequestBody IssuedBooksRequest request) {
        booksService.deleteIssuedBooks(request.getBookID(), request.getReaderId());
    }


}


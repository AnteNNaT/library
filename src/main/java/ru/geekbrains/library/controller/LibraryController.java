package ru.geekbrains.library.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.library.entity.Book;
import ru.geekbrains.library.entity.Reader;
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
    //public ListBooks getAllBooksByAuthor(@PathVariable Long author_id){
    //    return new ListBooks(booksService.findAllByAuthor_Id(author_id));
    // }

    @GetMapping("/readers/{reader_id}/books")
    public List<Book> getAllBooksByReader(@PathVariable Long reader_id) {
        return booksService.findAllBooksByReaderId(reader_id);
    }

    @GetMapping("/authors/{author_id}/readers")
    public List<Reader> getAllReadersByAuthor(@PathVariable Long author_id){
        return booksService.findAllReadersByAuthorId(author_id);
    }


}


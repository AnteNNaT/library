package ru.geekbrains.library.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import ru.geekbrains.library.entity.Book;
import ru.geekbrains.library.entity.IssuedBooks;
import ru.geekbrains.library.entity.Reader;
import ru.geekbrains.library.model.IssuedBooksRequest;

import java.util.List;


@SpringBootTest
@Transactional
class BooksServiceTest {

    @Autowired
    BooksService service;

    @Test
    void check() {

        List<Book> bookList = service.findAllBooksByAuthorId(1L);
        Assertions.assertEquals(2, bookList.size());
        Assertions.assertEquals("Война и мир", bookList.get(0).getTitle());

        List<Book> list = service.findAllBooksByReaderId(1L);
        Assertions.assertEquals(2, list.size());
        Assertions.assertEquals("Анна Каренина", list.get(1).getTitle());
        Assertions.assertEquals("451' по Фаренгейту", list.get(0).getTitle());

        List<Reader> readerList = service.findAllReadersByAuthorId(1L);
        Assertions.assertEquals(2, readerList.get(0).getId());

    }

    @Test
    void testInsertAndDelete() {
        IssuedBooksRequest request = new IssuedBooksRequest();
        request.setBookID(2L);
        request.setReaderId(1L);
        IssuedBooks issuedBooks = new IssuedBooks();
        issuedBooks.setBook(service.findBookById((Long) request.getBookID()));
        issuedBooks.setReader(service.findReaderById((Long) request.getReaderId()));
        issuedBooks.setIssueDate(new java.sql.Timestamp(System.currentTimeMillis()));
        issuedBooks = service.saveIssuedBooks(issuedBooks);
        Assertions.assertEquals(2, issuedBooks.getBook().getId());
        service.deleteIssuedBooks(2L, 1L);
        Assertions.assertNull(service.findIssuedBooksByBookIdAndReaderId(2L, 1L));
    }


}
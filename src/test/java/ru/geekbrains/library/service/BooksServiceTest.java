package ru.geekbrains.library.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;
import ru.geekbrains.library.entity.Book;
import ru.geekbrains.library.entity.IssuedBooks;
import ru.geekbrains.library.entity.Reader;
import ru.geekbrains.library.model.IssuedBooksRequest;

import java.util.List;


@SpringBootTest
@Transactional
@Sql("/data.sql")
class BooksServiceTest {

    @Autowired
    BooksService service;

    @Test
    void checkFindAllBooksByAuthorId() {

        List<Book> bookList = service.findAllBooksByAuthorId(1L);
        Assertions.assertEquals(2, bookList.size());
        Assertions.assertEquals("Война и мир", bookList.get(0).getTitle());
    }

    @Test
    void checkFindAllBooksByReaderId(){

        List<Book> list = service.findAllBooksByReaderId(1L);
        Assertions.assertEquals(2, list.size());
        Assertions.assertEquals("451' по Фаренгейту", list.get(0).getTitle());
        Assertions.assertEquals("Анна Каренина", list.get(1).getTitle());
    }

    @Test
    void checkFindAllReadersByAuthorId(){
        List<Reader> readerList = service.findAllReadersByAuthorId(1L);
        Assertions.assertEquals(2, readerList.get(0).getId());
    }

    @Test
    void testInsertAndDelete() {
        IssuedBooksRequest request = new IssuedBooksRequest();
        request.setBookID(3L);
        request.setReaderId(1L);
        IssuedBooks issuedBooks = new IssuedBooks();
        issuedBooks.setBook(service.findBookById((Long) request.getBookID()));
        issuedBooks.setReader(service.findReaderById((Long) request.getReaderId()));
        issuedBooks.setIssueDate(new java.sql.Timestamp(System.currentTimeMillis()));
        issuedBooks = service.saveIssuedBooks(issuedBooks);
        Assertions.assertEquals(3, issuedBooks.getBook().getId());
        service.deleteIssuedBooks(3L, 1L);
        Assertions.assertNull(service.findIssuedBooksByBookIdAndReaderId(3L, 1L));
    }


}
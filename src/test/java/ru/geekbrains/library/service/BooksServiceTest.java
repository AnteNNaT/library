package ru.geekbrains.library.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import ru.geekbrains.library.entity.Author;
import ru.geekbrains.library.entity.Book;
import ru.geekbrains.library.entity.Reader;
import ru.geekbrains.library.repository.AuthorRepository;
import ru.geekbrains.library.repository.BookRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BooksServiceTest {

    @Autowired
    BooksService service;

    @Test
    void check() {

     // List<Book> list=service.findAllBooksByAuthorId(1L);
     //  Assertions.assertEquals(2, list.size());
      // Assertions.assertEquals("Война и мир",list.get(0).getTitle());

        List<Book> list=service.findAllBooksByReaderId(1L);
        Assertions.assertEquals(2, list.size());
        Assertions.assertEquals("Анна Каренина",list.get(0).getTitle());
        Assertions.assertEquals("451' по Фаренгейту",list.get(1).getTitle());

        List<Reader> readerList=service.findAllReadersByAuthorId(1L);
        Assertions.assertEquals(1,readerList.get(0).getId());

       // Author author=service.findAuthorById(1L);
       // Assertions.assertEquals("Лев",author.getName());
    }

}
package ru.geekbrains.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.library.entity.Author;
import ru.geekbrains.library.entity.Book;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByAuthor_Id(Long author_id);
    Book findFirstById(Long id);
}

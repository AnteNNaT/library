package ru.geekbrains.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.library.entity.Author;
import ru.geekbrains.library.entity.Book;
import ru.geekbrains.library.entity.IssuedBooks;
import ru.geekbrains.library.entity.Reader;

import java.util.Collection;
import java.util.List;

public interface IssuedBooksRepository extends JpaRepository<IssuedBooks,Long> {

    List<IssuedBooks> findAllByReader_Id(Long reader_id);

    List<IssuedBooks> findAllByBook_Author_Id(Long author_id);
}

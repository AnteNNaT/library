package ru.geekbrains.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.library.entity.Author;

import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    Author findAuthorById(Long id);
}

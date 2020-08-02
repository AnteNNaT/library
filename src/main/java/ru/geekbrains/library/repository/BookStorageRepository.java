package ru.geekbrains.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.library.entity.BookStorage;

public interface BookStorageRepository extends JpaRepository<BookStorage, Long> {
}

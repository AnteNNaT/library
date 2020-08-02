package ru.geekbrains.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.library.entity.Reader;

public interface ReaderRepository extends JpaRepository<Reader,Long> {

    Reader findFirstById(Long id);
}

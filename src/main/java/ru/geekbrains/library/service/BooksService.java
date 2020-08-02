package ru.geekbrains.library.service;

import org.springframework.stereotype.Service;
import ru.geekbrains.library.entity.Author;
import ru.geekbrains.library.entity.Book;
import ru.geekbrains.library.entity.IssuedBooks;
import ru.geekbrains.library.entity.Reader;
import ru.geekbrains.library.repository.AuthorRepository;
import ru.geekbrains.library.repository.BookRepository;
import ru.geekbrains.library.repository.IssuedBooksRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class BooksService {

    private final IssuedBooksRepository issuedBooksRepository;
    private final BookRepository bookRepository;

    public BooksService(IssuedBooksRepository issuedBooksRepository, BookRepository bookRepository) {
        this.issuedBooksRepository = issuedBooksRepository;
        this.bookRepository = bookRepository;
    }


    public List<Book> findAllBooksByAuthorId(Long authorId){
        return bookRepository.findAllByAuthor_Id(authorId);
    }


    public List<Book> findAllBooksByReaderId(Long readerId){
        List<IssuedBooks> issuedBooks=issuedBooksRepository.findAllByReader_Id(readerId);
        List<Book> books =new ArrayList<>();
        for(IssuedBooks book: issuedBooks){
                books.add(book.getBook());
        }

        return books;
    }

    public List<Reader> findAllReadersByAuthorId(Long authorId){
        List<IssuedBooks> issuedBooks=issuedBooksRepository.findAllByBook_Author_Id(authorId);
        List<Reader> readers =new ArrayList<>();
        for(IssuedBooks books: issuedBooks){
            readers.add(books.getReader());
        }

        return  readers;
    }



}

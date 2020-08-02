package ru.geekbrains.library.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.geekbrains.library.entity.Book;
import ru.geekbrains.library.entity.IssuedBooks;
import ru.geekbrains.library.entity.Reader;
import ru.geekbrains.library.repository.BookRepository;
import ru.geekbrains.library.repository.IssuedBooksRepository;
import ru.geekbrains.library.repository.ReaderRepository;

import java.util.*;

@Service
public class BooksService {

    private final IssuedBooksRepository issuedBooksRepository;
    private final BookRepository bookRepository;
    private final ReaderRepository readerRepository;

    public BooksService(IssuedBooksRepository issuedBooksRepository, BookRepository bookRepository, ReaderRepository readerRepository) {
        this.issuedBooksRepository = issuedBooksRepository;
        this.bookRepository = bookRepository;
        this.readerRepository = readerRepository;
    }


    public List<Book> findAllBooksByAuthorId(Long authorId){
        return bookRepository.findAllByAuthor_Id(authorId);
    }

    public Book findBookById(Long id){
        return bookRepository.findFirstById(id);
    }

    public Reader findReaderById(Long id){
        return readerRepository.findFirstById(id);
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
        Set<Reader> readers =new LinkedHashSet<>();
        for(IssuedBooks books: issuedBooks){
            readers.add(books.getReader());
        }
        return  new ArrayList<>(readers);
    }

    public IssuedBooks saveIssuedBooks(IssuedBooks issuedBooks){
         return  issuedBooksRepository.save(issuedBooks);
    }

    public IssuedBooks findIssuedBooksByBookIdAndReaderId(Long bookId, Long readerId){
        return issuedBooksRepository.findFirstByBook_IdAndReader_Id(bookId,readerId);
    }

    @Transactional
    public  void deleteIssuedBooks(Long bookId, Long readerId){
        issuedBooksRepository.deleteAllByBook_IdAndReader_Id(bookId, readerId);
    }



}

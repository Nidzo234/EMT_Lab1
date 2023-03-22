package ukim.finki.lab1.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ukim.finki.lab1.model.Author;
import ukim.finki.lab1.model.Book;
import ukim.finki.lab1.model.Category;
import ukim.finki.lab1.model.Exception.InvalidIdException;
import ukim.finki.lab1.model.dto.BookDto;
import ukim.finki.lab1.repository.AuthorRepository;
import ukim.finki.lab1.repository.BookRepository;
import ukim.finki.lab1.service.BookService;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Book create(String name, Category category, Long authorId, Integer availableCopies) {
        Author a = authorRepository.findById(authorId).orElseThrow(InvalidIdException::new);
        Book newBook = new Book(name, category, a, availableCopies);
        return bookRepository.save(newBook);
    }

    @Override
    public Optional<Book> create(BookDto bookDto) {
        Book b = new Book(bookDto.getName(), bookDto.getCategory(), bookDto.getAuthor(), bookDto.getAvailableCopies());
        bookRepository.save(b);
        return Optional.of(b);
    }

    @Override
    public Optional<Book> edit(Long id, BookDto bookDto) {
        Book b = bookRepository.findById(id).orElseThrow(InvalidIdException::new);
        b.setCategory(bookDto.getCategory());
        b.setName(bookDto.getName());
        b.setAuthor(bookDto.getAuthor());
        b.setAvailableCopies(bookDto.getAvailableCopies());
        bookRepository.save(b);
        return Optional.of(b);
    }

    @Override
    public Book delete(Long id) {
        Book b = bookRepository.findById(id).orElseThrow(InvalidIdException::new);
        bookRepository.delete(b);
        return b;
    }

    @Override
    public Book update(Long id, String name, Category category, Author author, Integer availableCopies) {
        Book b = bookRepository.findById(id).orElseThrow(InvalidIdException::new);
        b.setName(name);
        b.setCategory(category);
        b.setAuthor(author);
        b.setAvailableCopies(availableCopies);
        return bookRepository.save(b);
    }

    @Override
    public Book markBook(Long id) {
        Book b = bookRepository.findById(id).orElseThrow(InvalidIdException::new);
        b.setAvailableCopies(b.getAvailableCopies()-1);
        return bookRepository.save(b);


    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Page<Book> findAllWithPagination(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }
}

package ukim.finki.lab1.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ukim.finki.lab1.model.Author;
import ukim.finki.lab1.model.Book;
import ukim.finki.lab1.model.Category;
import ukim.finki.lab1.model.dto.BookDto;

import java.util.List;
import java.util.Optional;

public interface BookService {
    Optional<Book> findById(Long id);
    Book create(String name, Category category, Long authorId, Integer availableCopies);
    Optional<Book> create(BookDto bookDto);
    Optional<Book> edit (Long id, BookDto bookDto);
    Book delete(Long id);
    Book update(Long id ,String name, Category category, Author author, Integer availableCopies);
    Book markBook(Long id);
    List<Book> findAll();
    Page<Book> findAllWithPagination(Pageable pageable);
}

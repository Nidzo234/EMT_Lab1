package ukim.finki.lab1.service;

import ukim.finki.lab1.model.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    Author create(Author a);
    List<Author> findAll();
    Optional<Author> findById(Long id);
}

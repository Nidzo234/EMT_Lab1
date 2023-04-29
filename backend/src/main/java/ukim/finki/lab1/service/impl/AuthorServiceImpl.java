package ukim.finki.lab1.service.impl;

import org.springframework.stereotype.Service;
import ukim.finki.lab1.model.Author;
import ukim.finki.lab1.repository.AuthorRepository;
import ukim.finki.lab1.service.AuthorService;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author create(Author a) {
        return authorRepository.save(a);
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Optional<Author> findById(Long id) {
        return authorRepository.findById(id);
    }
}

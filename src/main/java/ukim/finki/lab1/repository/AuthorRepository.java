package ukim.finki.lab1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ukim.finki.lab1.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}

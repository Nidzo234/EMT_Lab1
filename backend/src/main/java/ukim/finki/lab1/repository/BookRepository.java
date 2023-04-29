package ukim.finki.lab1.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ukim.finki.lab1.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Page<Book> findAll(Pageable pageable);
}

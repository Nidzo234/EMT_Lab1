package ukim.finki.lab1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ukim.finki.lab1.model.Country;

public interface CountryRepository extends JpaRepository<Country, Long> {
}

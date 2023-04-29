package ukim.finki.lab1.service;

import ukim.finki.lab1.model.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {

    Country create(Country c);
    List<Country> findAll();
    Optional<Country> findById(Long id);
}

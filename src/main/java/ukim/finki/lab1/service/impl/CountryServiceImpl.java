package ukim.finki.lab1.service.impl;

import org.springframework.stereotype.Service;
import ukim.finki.lab1.model.Country;
import ukim.finki.lab1.repository.CountryRepository;
import ukim.finki.lab1.service.CountryService;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {
    public final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public Country create(Country c) {
        return countryRepository.save(c);
    }

    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public Optional<Country> findById(Long id) {
        return this.countryRepository.findById(id);
    }
}

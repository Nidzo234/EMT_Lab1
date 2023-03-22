package ukim.finki.lab1.model.dto;

import jakarta.persistence.ManyToOne;
import ukim.finki.lab1.model.Country;

public class AuthorDto {
    String name;
    String surname;
    Country country;

    public AuthorDto(String name, String surname, Country country) {
        this.name = name;
        this.surname = surname;
        this.country = country;
    }
}

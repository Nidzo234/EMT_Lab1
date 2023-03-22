package ukim.finki.lab1.model.dto;

import lombok.Data;
import ukim.finki.lab1.model.Author;
import ukim.finki.lab1.model.Category;

@Data
public class BookDto {
    private String name;
    Category category;
    Author author;
    private int availableCopies;

    public BookDto() {
    }

    public BookDto(String name, Category category, Author author, int availableCopies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
    }
}

package ukim.finki.lab1.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    Category category;
    @ManyToOne
    Author author;
    private int availableCopies;
    public Book(String name, Category category, Author author, Integer availableCopies){
        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
    }

    public Book() {

    }
}

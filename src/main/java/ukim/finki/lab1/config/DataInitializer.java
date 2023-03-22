package ukim.finki.lab1.config;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ukim.finki.lab1.model.Author;
import ukim.finki.lab1.model.Book;
import ukim.finki.lab1.model.Category;
import ukim.finki.lab1.model.Country;
import ukim.finki.lab1.service.AuthorService;
import ukim.finki.lab1.service.BookService;
import ukim.finki.lab1.service.CountryService;

import java.util.List;

@Component
public class DataInitializer {
    private final BookService bookService;
    private final AuthorService authorService;
    private final CountryService countryService;

    public DataInitializer(BookService bookService, AuthorService authorService, CountryService countryService) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.countryService = countryService;
    }
    public Category randomCategory(int i){
        List<Category> c = List.of(Category.values());
        return c.get(i%c.size());
    }
    @PostConstruct
    public void initData(){
        for(int i=1;i<10;i++){
            Country c = new Country("Country " + i, "Europe");
            countryService.create(c);
            Author a = new Author("Author "+ i, "Surname " + i, c);
            authorService.create(a);
            bookService.create("book " + i, randomCategory(i), (long) i, i);
        }
    }
}

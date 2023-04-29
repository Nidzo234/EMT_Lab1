package ukim.finki.lab1.web;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ukim.finki.lab1.model.Author;
import ukim.finki.lab1.service.AuthorService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/authors")
public class AuthorController {

    //authorService
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }


    @GetMapping
    public List<Author> findAll(){
        return this.authorService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> findById(@PathVariable Long id){
        return this.authorService.findById(id)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}

package com.BookForUs.Authors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private AuthorService authorService;
    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/all-authors")
    public List<Author> getAllAuthors(){
       return authorService.getAllAuthors();
    }

    @PostMapping("/new-author/{authorName}")
    public Author addAAuthor(@PathVariable String authorName){
       return authorService.addAnAuthor(authorName);
    }

    @DeleteMapping("/delete-author")
    public void deleteAuthor(String authorName){
         authorService.deleteAnAuthor(authorName);
    }
}

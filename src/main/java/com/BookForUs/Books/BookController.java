package com.BookForUs.Books;

import com.BookForUs.Authors.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private BookService bookService;
    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/bookAuthor")
    public List<Books>getBooksByAuthor(@RequestParam String authorName){
        return bookService.findBooksByAuthor(authorName);
    }
    @GetMapping("/bookTitle")
    public List<Books>getBooksWithSimilarThemes(@RequestParam String title){
        return bookService.findBooksWithSimilarTheme(title);
    }
    @GetMapping("/all-books")
    public List<Books>allBooks(){
        return bookService.allBooks();
    }
    @PostMapping("/new-book")
    public void addABook(@RequestParam String title,
                         @RequestParam Themes theme,
                         @RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy")LocalDate publication,
                         @RequestParam Author author){
        bookService.addANewBook(title,publication,author,theme);
    }

}

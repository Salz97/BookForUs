package com.BookForUs.Books;

import com.BookForUs.Authors.Author;
import com.BookForUs.Authors.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;

    public List<Books>findBooksByAuthor(String authorName){
        int authorID= authorRepository.findAuthorIdByName(authorName);
        Author author1= authorRepository.findById(authorID).get();

        return bookRepository.findAllBooksByAuthor(author1);
    }

    //find books with similar themes, first find book with the name, then find the theme of that book, then
}

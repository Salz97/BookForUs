package com.BookForUs.Books;

import com.BookForUs.Authors.Author;
import com.BookForUs.Authors.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.context.Theme;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;

    @Transactional
    public List<Books>allBooks(){
        return bookRepository.findAll();
    }

    public List<Books>findBooksByAuthor(String authorName){
        int authorID= authorRepository.findAuthorIdByName(authorName);
//        Author author1= authorRepository.findById(authorID).get();
        // this doesn't work as author is stored in the books table as an id.

        return bookRepository.findAllBooksByAuthor(authorID);
    }

    //find books with similar themes, first find book with the name, then find the theme of that book, then
    public List<Books> findBooksWithSimilarTheme(String bookName){
//        Books book= bookRepository.findBookByName(bookName);
      int theme= bookRepository.findBookTheme(bookName);
      return bookRepository.findSimilarBooksWithTheme(theme);


    }
    @Transactional
    public void addANewBook(String title, LocalDate publication, Author author, Themes theme){
        Books book= new Books();
        book.setAuthor(author);
        book.setTitle(title);
        book.setPublicationDate(publication);
        book.setThemes(theme);
        bookRepository.save(book);
    }

}


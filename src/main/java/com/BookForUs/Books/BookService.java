package com.BookForUs.Books;

import com.BookForUs.Authors.Author;
import com.BookForUs.Authors.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.context.Theme;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @Autowired
    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

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
    public Books findABook(String title){
        return bookRepository.findBookByName(title);
    }

    //find books with similar themes, first find book with the name, then find the theme of that book, then
    public List<Books>findBooksWithSimilarTheme(String title){
       int theme= bookRepository.findBookTheme(title);
       if(theme>=0) {
           return bookRepository.findSimilarBooksWithTheme(theme);
       }
       return bookRepository.findAll();
    }
    @Transactional
    public void addANewBook(String title, LocalDate publication, Author author, Themes theme){
        Books book= new Books(title,publication,author,theme);
        book.setAuthor(author);
        book.setTitle(title);
        book.setPublicationDate(publication);
        book.setThemes(theme);
        bookRepository.save(book);
    }

    @Transactional
    public List<Books>findByWord(String word){
        List<Books>allBooks=bookRepository.findAll();
        Predicate<Books>books=book->book.getTitle().contains(word);
        Predicate<Books>books1=book-> book.getAuthor().getAuthorName().contains(word);

        return allBooks.stream().filter(books.or(books1)).collect(Collectors.toList());

    }
//    @Transactional
//    public List<Books> generateAllBooksWithWordsOfTitle(String title){
//        String[] words= title.split(" ");
//        List<Books>book= bookRepository.findAll();
//        LinkedList<Books>booksForThis= new LinkedList<>();
//        for(int i=0;i< words.length;i++){
//            for(int j=0;j<book.size();j++){
//                if(book.get(j).getTitle().contains(words[i])){
//                    booksForThis.add(book.get(j));
//                }
//            }
//        }
//        return booksForThis;
//    }



        
    }




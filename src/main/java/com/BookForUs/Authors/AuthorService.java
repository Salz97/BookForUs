package com.BookForUs.Authors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;
    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Transactional
    public List<Author> getAllAuthors(){
        return authorRepository.findAll();
    }

    @Transactional
    public Author addAnAuthor(String name){
        Author author=new Author();
        author.setAuthorName(name);
        authorRepository.save(author);
        return author;
    }
    @Transactional
    public void deleteAnAuthor(String authorName){
        Author author = authorRepository.findAuthorBYName(authorName);
        authorRepository.delete(author);

    }

}

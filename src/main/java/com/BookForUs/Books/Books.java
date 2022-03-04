package com.BookForUs.Books;

import com.BookForUs.Authors.Author;
import com.BookForUs.Users.User;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity(name="Book")
@Table(name="books")
public class Books {
    @Id
    @SequenceGenerator(name = "books_sequence",sequenceName = "books_sequence",
         allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "books_sequence")

    @Column(name = "books_id", nullable = false)
    private int id;

    @Column(name="title",nullable = false)
    private String title;

    @Column(name = "publication_date",nullable = false)
    private LocalDate publicationDate;

    @ManyToMany(mappedBy = "books")
    private Set<User>users;


    @Column(name="Theme")
    private Themes themes;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author",referencedColumnName = "author_" +
            "" +
            "id")
    private Author author;

    public Books(int id, String title, LocalDate publicationDate, Set<User> users, Themes themes, Author author) {
        this.id = id;
        this.title = title;
        this.publicationDate = publicationDate;
        this.users = users;
        this.themes = themes;
        this.author = author;
    }

    public Books() {
    }

    public Books(String title, LocalDate publication, Author author, Themes theme) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Themes getThemes() {
        return themes;
    }

    public void setThemes(Themes themes) {
        this.themes = themes;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}

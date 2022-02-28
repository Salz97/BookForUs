package com.BookForUs.Books;

import com.BookForUs.Authors.Author;
import com.BookForUs.Users.User;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity(name="books")
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


}

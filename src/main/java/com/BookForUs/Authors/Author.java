package com.BookForUs.Authors;

import com.BookForUs.Books.Books;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "author")
@Table(name = "author")

public class Author {
    @Id
    @SequenceGenerator(
            name = "author_sequence",
            sequenceName = "author_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "author_sequence"
    )
    @Column(name="author_id")
    private int id;

    @Column(name="author_name")
    private String authorName;

    @OneToMany(mappedBy = "author")
    private Set<Books>books;

    public Author(int id, String authorName) {
        this.id = id;
        this.authorName = authorName;
    }


    public Author() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", authorName='" + authorName + '\'' +
                '}';
    }
}

package com.BookForUs.Users;

import com.BookForUs.Books.Books;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.Set;

@Entity(name="User")
@Table(name="users")
public class User {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    @Column(
            name = "user_id",
            updatable = false
    )
    private int id;

    @Column(
            name = "user_name",
            nullable = false,
            unique = true
    )
    private String userName;

    @Column(
            name = "user_email",
            nullable = false,
            unique = true
    )
    private String email;

    @Column(
            name = "user_password",
            nullable = false,
            columnDefinition = "CHAR(60)"
    )
    private String password;

    @Column(
            name = "logged_in",
            nullable = false
    )
    private boolean loggedIn;


    @ManyToMany(cascade =CascadeType.MERGE)
    @JoinTable(name= "Users_books",
            joinColumns = @JoinColumn(name= "user_id"),
            inverseJoinColumns = @JoinColumn(name= "book_id"))
    private Set<Books> books;
    public User() {
    }

    public User(String userName, String email, String password, String loggedIn) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.loggedIn = false;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }


    public Set<Books> getBooks() {
        return books;
    }

    public void setBooks( Set<Books> books) {
        this.books = books;
    }
}

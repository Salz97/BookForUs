package com.BookForUs.Users;

import com.BookForUs.Books.BookRepository;
import com.BookForUs.Books.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class UserService {

    private UserRepository userRepository;
    private User userLoggedIn;
    private BookRepository bookRepository;

    @Autowired
    public UserService(UserRepository userRepository,BookRepository bookRepository) {
        this.userRepository = userRepository;
        this.userLoggedIn = null;
        this.bookRepository = bookRepository;
    }




    @Transactional
    public List<User>getAllUsers(){
        return userRepository.findAll();
    }
    @Transactional
    public void addNewUser(String userName, String email, String password) {


        User newUser = new User();
        newUser.setUserName(userName);
        if(email.contains("@")) {
            newUser.setEmail(email);
        }else{
            throw new IllegalStateException("this email does not work");
        }
        newUser.setPassword(password);





        userRepository.save(newUser);


    }

    @Transactional
    public void updateUserAccountDetails(String email, String password,
                                         String updatedPassword, String updatedUsername) {
        User user = userRepository.findUser(email, password);

        if (user != null) {
            if (updatedPassword != null) {
                user.setPassword(updatedPassword);
            }
            if (updatedUsername != null) {
                user.setUserName(updatedUsername);
            }
        } else {
            throw new IllegalStateException("User does not exist");
        }
    }

    private Books findBooks(String title){
       return bookRepository.findBookByName(title);
    }
    public User addBooksToUser(String email, String password,String title){
        User user= userRepository.findUser(email,password);
        Set<Books> bookSet= user.getBooks();
        Books book= findBooks(title);
        bookSet.add(book);
        user.setBooks(bookSet);

        return user;
    }


}

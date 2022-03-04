package com.BookForUs.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<User> getAllUsers(){
       return userService.getAllUsers();
    }


    @PostMapping("/new-account")
    public void addNewUser(@RequestParam String userName,
                           @RequestParam String userEmail,
                           @RequestParam String userPassword
    ){

        userService.addNewUser(userName, userEmail, userPassword);

    }

    @PutMapping("/update-account-details")
    public void updateUserAccountDetails(@RequestParam String email,
                                         @RequestParam String password,
                                         @RequestParam(required = false) String updatedPassword,
                                         @RequestParam(required = false) String updatedUsername) {

        userService.updateUserAccountDetails(email, password, updatedPassword, updatedUsername);
    }
    @PutMapping("/addBooks")
    public User addBooks(@RequestParam String email,
                         @RequestParam String password,
                          @RequestParam String title){
        return userService.addBooksToUser(email, password, title);
    }

}

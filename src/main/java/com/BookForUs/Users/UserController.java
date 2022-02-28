package com.BookForUs.Users;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    @GetMapping("/all")
    public void getAllUsers(){
        userService.getAllUsers();
    }
}

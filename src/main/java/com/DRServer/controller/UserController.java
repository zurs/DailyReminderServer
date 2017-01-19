package com.DRServer.controller;

import com.DRServer.domain.User;
import com.DRServer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Hampus on 2017-01-15.
 */
@RestController
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST) // Register a new User
    public User registerUser(@RequestBody User newUser){
        return userService.registerUser(newUser);
    }

    @RequestMapping(value = "/{token}", method = RequestMethod.GET) // Check if token exists, for login
    public boolean checkToken(@PathVariable(value = "token") String token){
        return userService.checkToken(token);
    }


}

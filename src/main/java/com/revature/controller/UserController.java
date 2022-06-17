package com.revature.controller;

import com.revature.model.Make;
import com.revature.model.User;
import com.revature.service.UserService;
import io.javalin.http.Handler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class UserController {


    UserService userService;

    public UserController(){userService = new UserService();}

    public UserController(UserService userService) { this.userService = userService;}

    public Handler getAllUsers = context -> {
       context.json(userService.getAllUsers());


    };

    public Handler setUser = context -> {
        User user = context.bodyAsClass(User.class);
        userService.createUser(user);
    };




}

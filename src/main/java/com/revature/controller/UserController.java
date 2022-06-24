package com.revature.controller;


import com.revature.model.Role;
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
        String roleParam = context.queryParam("role");


        if(roleParam == null){ // if role is null, get all users
            context.json(userService.getAllUsers());
        }else { // if role is not null, get all users by role
            try{
                // check if its a valid role
                Role role = Role.valueOf(roleParam.toUpperCase());
                context.json(userService.getAllUsersByRole(role));
            } catch(IllegalArgumentException e) {
                context.status(400).result("Please enter a valid role: " + Arrays.toString(Role.values()));
            }
        }




    };

    public Handler getUserById = context -> {
        String param = context.pathParam("id");

        try{
            User user = userService.getUserById(Integer.parseInt(param)
            );
            if(user != null){
                context.json(user);
            } else {
                context.result("User not found").status(404);
            }
        } catch(NumberFormatException e){
            context.result("Please enter only valid integers as an id");
            context.status(400);
        }
    };

    public Handler createUser = context -> {
        User user = context.bodyAsClass(User.class);
        user = userService.createUser(user);

        if(user != null){
            context.json(user);
        } else {

            context.result("User not created").status(400);
        }
    };




}

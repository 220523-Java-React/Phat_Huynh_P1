package com.revature;

import com.revature.controller.CarController;
import com.revature.controller.UserController;
import com.revature.model.User;
import com.revature.service.CarService;
import io.javalin.Javalin;

public class Driver {
    public static void main(String[] args){
        CarController carController = new CarController();
        UserController userController = new UserController();
        Javalin app = Javalin.create().start(8080);


        app.get("/cars", carController.getAllCars);
        app.get("/cars/{id}", carController.getCarById);
        app.post("/cars", carController.setCar);

        app.get("/users", userController.getAllUsers);
        app.post("/users", userController.setUser);



    }
}

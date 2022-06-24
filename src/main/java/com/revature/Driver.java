package com.revature;

import com.revature.controller.CarController;
import com.revature.controller.OfferController;

import com.revature.controller.UserController;
import com.revature.model.User;
import com.revature.service.CarService;
import io.javalin.Javalin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Driver {

    static Logger logger = LoggerFactory.getLogger(Driver.class);

    public static void main(String[] args){
        logger.error("This is an error");
        CarController carController = new CarController();
        UserController userController = new UserController();
        OfferController offerController = new OfferController();

        Javalin app = Javalin.create().start(8080);


        app.get("/cars", carController.getAllCars);
//        app.get("/cars/{id}", carController.getCarById);
        app.post("/cars", carController.createNewCar);

        app.get("/users", userController.getAllUsers);
        app.post("/users", userController.createUser);

        app.get("/offers", offerController.getAllOffers);
//        app.post("/offers", offerController.createNewOffer);
        app.post("/offers", offerController.updateOffer);
//      app.get("/offers", offerController.getOfferByUsername);



    }
}

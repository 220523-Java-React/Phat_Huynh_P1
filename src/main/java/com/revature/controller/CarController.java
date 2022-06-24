package com.revature.controller;

import com.revature.model.Car;

import com.revature.model.User;
import com.revature.service.CarService;
import com.revature.service.UserService;
import io.javalin.http.Handler;
import org.eclipse.jetty.http.HttpStatus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class CarController {
    CarService carService;

    public CarController(){ carService = new CarService();}
    public CarController(CarService carService) { this.carService = carService;}

    public Handler getAllCars = context -> {
        context.json(carService.getAllCars());
    };

    public Handler createNewCar = context ->{

        Car car = context.bodyAsClass(Car.class);
        carService.createNewCar(car);
    };





}

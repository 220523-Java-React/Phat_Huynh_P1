package com.revature.controller;

import com.revature.model.Car;
import com.revature.service.CarService;
import io.javalin.http.Handler;

public class CarController {
    CarService carService = new CarService();
    public Handler getAllCars = context -> {
        context.result(carService.getAllCarsAsString());

    };



    public Handler getCarById = context -> {
        String param = context.pathParam("id");
        int id = Integer.parseInt(param);

      context.json(carService.getCarById(id));
    };

    public Handler setCarId = context ->{
      Car car = context.bodyAsClass(Car.class);
      carService.createNewCar(car);
    };

}
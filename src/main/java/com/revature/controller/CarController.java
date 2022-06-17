package com.revature.controller;

import com.revature.model.Car;
import com.revature.model.Make;
import com.revature.model.Model;
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
    CarService carService = new CarService();

    public Handler getAllCars = context -> {
        List<Car> cars = new ArrayList<>();
        String makeParamMake = context.queryParam("make");
        if(makeParamMake == null ){
            cars = carService.getAllCars();
        }
        else {
            try{
                Make make = Make.valueOf(makeParamMake); //.toUpperCase(Locale.ROOT));
                cars = carService.getAllCarsByMake(make);
            }catch (IllegalArgumentException e){
                String failureMessage = "{\"success\":false, \"message\":\"" +
                        "Please only use the following topic values: " + Arrays.toString(Make.values())
                        + "\"}";
                context.status(400).json(failureMessage);
                return;
            }
        }



        String makeParamModel = context.queryParam("model");
        if(makeParamModel == null ){
            cars = carService.getAllCars();
        }
        else {
            try{
                Model model = Model.valueOf(makeParamModel); //.toUpperCase(Locale.ROOT));
                cars = carService.getAllCarsByModel(model);
            }catch (IllegalArgumentException e){
                String failureMessage = "{\"success\":false, \"message\":\"" +
                        "Please only use the following topic values: " + Arrays.toString(Make.values())
                        + "\"}";
                context.status(400).json(failureMessage);
                return;
            }
        }


        context.json(cars);
    };





      public Handler getCarById = context -> {
        String param = context.pathParam("id");
        int id = 0;
        try{
            id = Integer.parseInt(param);
            context.json(carService.getCarById(id));
        } catch (NumberFormatException e){
            context.result("stop giving me words as IDS");
            context.status(HttpStatus.BAD_REQUEST_400);
        } catch(NullPointerException e){
            System.out.println("Oops");
        }


     };

    public Handler setCar = context ->{
      Car car = context.bodyAsClass(Car.class);
      carService.createNewCar(car);
    };





}

package com.revature.service;

import com.revature.model.Car;

import java.util.ArrayList;
import java.util.List;

public class CarService {

    private List<Car> cars = new ArrayList<>();

    public CarService(){

    }
    public void createNewCar(Car car){
        cars.add(car);
    }

    public List<Car> getAllCars(){
        return cars;

    }

    public Car getCarById(int id){
        for(Car car : cars){
            if(car.id == id){
                return car;
            }
        }
        return null;
    }


    public String getAllCarsAsString(){
        List<Car> cars = getAllCars();
        StringBuilder builder = new StringBuilder();


        for (Car car : cars) {
            builder.append(car.brand).append("\n")
                    .append(car.type).append("\n\n");
        }
//
        return builder.toString();
    }

    public int carCount(){
        return cars.size();
    }


    // return x;
       // StringBuilder builder = new StringBuilder();
       // return builder.toString();


}

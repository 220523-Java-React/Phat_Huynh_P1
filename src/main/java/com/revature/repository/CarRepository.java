package com.revature.repository;

import com.revature.model.Car;
import com.revature.model.Make;
import com.revature.model.Model;

import java.util.ArrayList;
import java.util.List;

public class CarRepository implements DAO<Car> {

    private List<Car> cars;

    public CarRepository(){cars=new ArrayList<>();}

    public CarRepository(List<Car> cars) { this.cars = cars;}

    @Override
    public Car create(Car car) {
        if(cars.add(car)){
            return car;
        } else {
            return null;
        }


    }

    @Override
    public List<Car> getAll(){return cars;}

    @Override
    public Car getById(int id) {
        for(int i = 0; i <cars.size(); i++){
            if (cars.get(i).getId() == id) {
                return cars.get(i);
            }
        }
        return null;
    }

    public List<Car> getAllByModel(Model model){
        List<Car> filteredCars = new ArrayList<>();

        for(Car car: cars){
            if(car.getModel().equals(model)){
                filteredCars.add(car);
            }
        }
        return filteredCars;
    }

    public List<Car> getAllByMake(Make make){
        List<Car> filteredCars = new ArrayList<>();

        for(Car car: cars){
            if(car.getMake().equals(make)){
                filteredCars.add(car);
            }
        }
        return filteredCars;
    }

    @Override
    public Car update(Car car) {return null;}

    @Override
    public boolean deleteById(int id) {return false;}
}

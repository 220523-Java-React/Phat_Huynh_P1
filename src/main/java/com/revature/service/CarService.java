package com.revature.service;

import com.revature.model.Car;

import com.revature.repository.CarRepository;

import java.util.ArrayList;
import java.util.List;

public class CarService {

   private CarRepository carRepository;

   public CarService() {
       carRepository = new CarRepository();
   }

   public CarService(CarRepository carRepository) {
       this.carRepository = carRepository;
   }

   public Car createNewCar(Car car) {
       return carRepository.create(car);
   }

   public List<Car> getAllCars() {
       return carRepository.getAll();
   }

//   public List<Car> getAllCarsByMake(Make make){
//       return carRepository.getAllByMake(make);
//   }
//    public List<Car> getAllCarsByModel(Model model){
//        return carRepository.getAllByModel(model);
//    }
//   public Car getCarById(int id) {
//       return carRepository.getById(id);
//   }



    // return x;
       // StringBuilder builder = new StringBuilder();
       // return builder.toString();


}

package com.revature.model;

import java.io.Serializable;
import java.util.Objects;

public class Car implements Serializable {
private int id;
public String brand;

public CarColor color;
private Make make;
private Model model;

public String type;

    public int getId(){return id;}
    public Make getMake(){return make;}


    public Car(){

   }

    public Car(  String brand, String type){
    this.brand= brand;
    this.type = type;
    }

    public Car(int id, String brand, String type){
        this.id = id;
        this.brand = brand;
        this.type = type;
    }

    public CarColor getColor(){return color;}

    public Model getModel(){return model;}



    public void setColor(CarColor color){this.color = color;}
    public void setModel(Model model){
        this.model = model;
    }


//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Car car = (Car) o;
//        return id == car.id && Objects.equals(brand, car.brand) && Objects.equals(type, car.type) && make == car.make
//                && color ==car.color && model ==car.model;
//    }
//
//
//
//    @Override
//    public String toString() {
//        return "brand" + brand + "\n"+ "make" + make + "\n" + "type" + type + "\n" + model + "\n" + "type" + color + "\n" +"teessstttt";
//    }


//hello

}

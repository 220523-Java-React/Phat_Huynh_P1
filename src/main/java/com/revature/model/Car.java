package com.revature.model;

import java.io.Serializable;
import java.util.Objects;

public class Car implements Serializable {
private int id;
private String color;
private String make;
private String model;
private int year;
private int price;

  public Car(){

  }


   public int getId() {return id;}
    public Car setId(int id){this.id = id; return this;}

    public String getColor(){return color;}
    public Car setColor(String color){ this.color = color; return this;}

    public String getMake(){return make;}
    public Car setMake(String make){this.make = make; return this;}

    public String getModel(){return model;}
    public Car setModel(String model){this.model = model; return this;}

    public int getYear(){return year;}

    public Car setYear(int year){this.year = year; return this;}
    public int getPrice(){return price;}
    public Car setPrice(int price){this.price = price; return this;}










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

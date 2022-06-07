package com.revature.model;

public class Car {
public int id;
public String brand;

public String type;

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




    @Override
    public String toString() {
        return "id" + brand + "\n"
                + "type" + type + "\n";
    }


//hello

}

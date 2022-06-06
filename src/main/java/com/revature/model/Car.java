package com.revature.model;

public class Car {
public int id;
public String type;

    public Car(int id, String type){
    this.id = id;
    this.type = type;
    }

    @Override
    public String toString() {
        return "id" + id + "\n"
                + "type" + type;
    }



}

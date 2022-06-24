package com.revature.model;

import java.io.Serializable;

public class Offer implements Serializable {
    private int id;
    private int offer;
    private String make;
    private String model;
    private int year;
    private String color;
    private int price;

    private String test;

    private Status status;


    private String username;
     public Offer(){

     }
     public String test() { return test;}
    public Offer setTest(String test){
         this.test = test;
         return this;
    }

    public int getId() { return id;}

    public Offer setId(int id) {
        this.id = id;
        return this;}

    public int getOffer() {return offer;}
    public Offer setOffer(int offer){ this.offer = offer; return this;}

    public String getMake() {return make;}
    public Offer setMake(String make){this.make = make; return this;}

    public int getYear(){return year;}
    public Offer setYear(int year){this.year=year; return this;}

    public String getColor(){return color;}
    public Offer setColor(String color){this.color=color; return this;}

    public int getPrice(){return price;}
    public Offer setPrice(int price){this.price=price; return this;}

    public String getModel(){return model;}
    public Offer setModel(String model){this.model = model; return this;}

    public String getUserName() {return username;}
    public Offer setUserName(String username){ this.username = username; return this;}



    public Status getStatus(){return status;}
    public Offer setStatus(Status status){this.status = status; return this;}



}

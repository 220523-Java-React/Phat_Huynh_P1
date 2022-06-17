package com.revature.model;

public enum CarColor {
    BLUE("BLUE"),
    RED("RED"),
    YELLOW("YELLOW"),
    GREEN("GREEN"),
    BLACK("BLACK"),
    SILVER("SILVER");

    public final String value;

    CarColor(String value){
        this.value = value;
    }


}

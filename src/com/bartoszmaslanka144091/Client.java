package com.bartoszmaslanka144091;

import javafx.scene.shape.Circle;

import java.util.ArrayList;

public class Client extends Person {
    String firstName;
    String lastName;
    Circle obj;



    public void consume(){

    };
    public void nextShop(){};

    public Client(int id, Boolean isSick, Boolean wearsMask, Boolean vaccinated, Float chanceToGetSick, int shopsToGetWell,
                  int currentCapacity, int maxCapacity, ArrayList<Product> bag, String firstName, String lastName) {
        super(id, isSick, wearsMask, vaccinated, chanceToGetSick, shopsToGetWell, currentCapacity, maxCapacity, bag);
        this.firstName = firstName;
        this.lastName = lastName;

    }

    @Override
    public String toString() {
        return "Client{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", cartCapacity=" + this.maxCapacity +
                ", cart=" + bag +
                '}';
    }

    public Circle getObj() {
        return obj;
    }

    public void setObj(Circle obj) {
        this.obj = obj;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}



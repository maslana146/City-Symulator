package com.bartoszmaslanka144091;

import java.util.ArrayList;

public class Client extends Person {
    String firstName;
    String lastName;
    int cartCapacity;
    ArrayList<Product> cart;

    public void consume(){

    };
    public void nextShop(){};

    public Client(int id, Boolean isSick, Boolean wearsMask, Boolean vaccinated, Float chanceToGetSick, int shopsToGetWell,
                  int currentCapacity, int maxCapacity, ArrayList<Product> bag, String firstName, String lastName, int cartCapacity, ArrayList<Product> cart) {
        super(id, isSick, wearsMask, vaccinated, chanceToGetSick, shopsToGetWell, currentCapacity, maxCapacity, bag);
        this.firstName = firstName;
        this.lastName = lastName;
        this.cartCapacity = cartCapacity;
        this.cart = cart;
    }

    @Override
    public String toString() {
        return "Client{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", cartCapacity=" + cartCapacity +
                ", cart=" + cart +
                '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getCartCapacity() {
        return cartCapacity;
    }

    public ArrayList<Product> getCart() {
        return cart;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCartCapacity(int cartCapacity) {
        this.cartCapacity = cartCapacity;
    }

    public void setCart(ArrayList<Product> cart) {
        this.cart = cart;
    }
}



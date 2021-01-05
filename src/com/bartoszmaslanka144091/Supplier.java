package com.bartoszmaslanka144091;

import java.util.ArrayList;

public class Supplier extends Person {
    String companyName;
    String carBrand;

    ArrayList<Shop> listOfStops;
    float fuelConsumption;
    float fuelCapacity;
    float currentFuel;

    void leaveProduct(Product product, Shop shop){

        shop.availableProducts.add(product);
        bag.remove(product);
        currentCapacity -= 1;

    };

    void tank(){
        this.fuelCapacity = 1;
    };

    public Supplier(int id, Boolean isSick, Boolean wearsMask, Boolean vaccinated, Float chanceToGetSick, int shopsToGetWell,
                    int currentCapacity, int maxCapacity, ArrayList<Product> bag, String companyName, String carBrand, ArrayList<Shop> listOfStops, float fuelConsumption, float fuelCapacity, float currentFuel) {
        super(id, isSick, wearsMask, vaccinated, chanceToGetSick, shopsToGetWell, currentCapacity, maxCapacity, bag);
        this.companyName = companyName;
        this.carBrand = carBrand;
        this.listOfStops = listOfStops;
        this.fuelConsumption = fuelConsumption;
        this.fuelCapacity = fuelCapacity;
        this.currentFuel = currentFuel;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "companyName='" + companyName + '\'' +
                ", carBrand='" + carBrand + '\'' +
                ", listOfStops=" + listOfStops +
                ", fuelConsumption=" + fuelConsumption +
                ", fuelCapacity=" + fuelCapacity +
                ", currentFuel=" + currentFuel +
                '}';
    }
}

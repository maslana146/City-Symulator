package com.bartoszmaslanka144091;

import com.bartoszmaslanka144091.Controllers.WorldScreen;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class Supplier extends Person {
    String companyName;
    String carBrand;

    ArrayList<StaticObject> listOfStops;
    float fuelConsumption;
    float fuelCapacity;
    float currentFuel;
    StaticObject nextShop;

    public StaticObject getNextShop() {
        return nextShop;
    }

    public void addNextShop() {
        if (Generators.genFloat(0, 1) < 0.5) {
            int nextShop = Generators.genInteger(0, 3);
            listOfStops.add(WorldScreen.staticObjects.get(nextShop));
        } else {
            int nextShop = Generators.genInteger(3, WorldScreen.staticObjects.size());
            listOfStops.add(WorldScreen.staticObjects.get(nextShop));
        }
    }

    public StaticObject getNewNextShop() {
        StaticObject shop = listOfStops.get(0);
        listOfStops.remove(0);
        this.nextShop = shop;
        return shop;
    }

    ;

    public void newListOfStops() {
        for (int i = 0; i < 5; i++) {
            int shop = Generators.genInteger(0, WorldScreen.staticObjects.size());
            listOfStops.add(WorldScreen.staticObjects.get(shop));
        }
    }

    void tank() {
        this.fuelCapacity = 1;
    }

    ;

    public Supplier(int id, Boolean isSick, Boolean wearsMask, Boolean vaccinated, Float chanceToGetSick, int shopsToGetWell,
                    int currentCapacity, int maxCapacity, ObservableList<Product> bag, String companyName, String carBrand, ArrayList<StaticObject> listOfStops, float fuelConsumption, float fuelCapacity, float currentFuel) {
        super(id, isSick, wearsMask, vaccinated, chanceToGetSick, shopsToGetWell, currentCapacity, maxCapacity, bag);
        this.companyName = companyName;
        this.carBrand = carBrand;
        this.listOfStops = listOfStops;
        this.fuelConsumption = fuelConsumption;
        this.fuelCapacity = fuelCapacity;
        this.currentFuel = currentFuel;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public void setListOfStops(ArrayList<StaticObject> listOfStops) {
        this.listOfStops = listOfStops;
    }

    public void setFuelConsumption(float fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public void setFuelCapacity(float fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public void setCurrentFuel(float currentFuel) {
        this.currentFuel = currentFuel;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public ArrayList<StaticObject> getListOfStops() {
        return listOfStops;
    }

    public float getFuelConsumption() {
        return fuelConsumption;
    }

    public float getFuelCapacity() {
        return fuelCapacity;
    }

    public float getCurrentFuel() {
        return currentFuel;
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

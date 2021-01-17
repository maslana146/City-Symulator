package com.bartoszmaslanka144091;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Person {
    int id;
    Boolean isSick;
    Boolean wearsMask;
    Boolean vaccinated;
    Float chanceToGetSick;
    int shopsToGetWell;
    int currentCapacity;
    int maxCapacity;
    ObservableList<Product> bag = FXCollections.observableArrayList();

    public void currentPosition() {
    }

    ;

    public void takeProducts() {
    }

    ;

    public void findPath() {
    }

    ;

    public void move() {
    }

    ;

    public Person(int id, Boolean isSick, Boolean wearsMask, Boolean vaccinated, Float chanceToGetSick,
                  int shopsToGetWell, int currentCapacity, int maxCapacity, ObservableList<Product> bag) {
        this.id = id;
        this.isSick = isSick;
        this.wearsMask = wearsMask;
        this.vaccinated = vaccinated;
        this.chanceToGetSick = chanceToGetSick;
        this.shopsToGetWell = shopsToGetWell;
        this.currentCapacity = currentCapacity;
        this.maxCapacity = maxCapacity;
        this.bag = bag;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                '}';
    }

    public int getId() {
        return id;
    }

    public Boolean getIsSick() {
        return isSick;
    }

    public Boolean getWearsMask() {
        return wearsMask;
    }

    public Boolean getVaccinated() {
        return vaccinated;
    }

    public Float getChanceToGetSick() {
        return chanceToGetSick;
    }

    public int getShopsToGetWell() {
        return shopsToGetWell;
    }

    public int getCurrentCapacity() {
        return currentCapacity;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public ObservableList<Product> getBag() {
        return bag;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIsSick(Boolean sick) {
        isSick = sick;
    }

    public void setWearsMask(Boolean wearsMask) {
        this.wearsMask = wearsMask;
    }

    public void setVaccinated(Boolean vaccinated) {
        this.vaccinated = vaccinated;
    }

    public void setChanceToGetSick(Float chanceToGetSick) {
        this.chanceToGetSick = chanceToGetSick;
    }

    public void setShopsToGetWell(int shopsToGetWell) {
        this.shopsToGetWell = shopsToGetWell;
    }

    public void setCurrentCapacity(int currentCapacity) {
        this.currentCapacity = currentCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public void setBag(ObservableList<Product> bag) {
        this.bag = bag;
    }
}

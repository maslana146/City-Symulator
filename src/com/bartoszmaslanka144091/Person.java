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

    /**
     * constructor
     * @param id
     * @param isSick
     * @param wearsMask
     * @param vaccinated
     * @param chanceToGetSick
     * @param shopsToGetWell
     * @param currentCapacity
     * @param maxCapacity
     * @param bag
     */
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

    /**
     * @return to string method
     */
    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                '}';
    }

    /**
     *  sets shops to get well if sick or not
     */
    public void getWell() {
        if (isSick) {
            shopsToGetWell -= 1;
        } else shopsToGetWell = 0;
        if (shopsToGetWell == 0){
            isSick = false;
        }
    }

    /**
     * @return getter
     */
    public int getId() {
        return id;
    }

    /**
     * @return gettter
     */
    public Boolean getIsSick() {
        return isSick;
    }

    public Boolean getWearsMask() {
        return wearsMask;
    }

    /**
     * @return getter
     */
    public Boolean getVaccinated() {
        return vaccinated;
    }

    public Float getChanceToGetSick() {
        return chanceToGetSick;
    }

    /**
     * @return getter
     */
    public int getShopsToGetWell() {
        return shopsToGetWell;
    }

    public int getCurrentCapacity() {
        return currentCapacity;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    /**
     * @return getter
     */
    public ObservableList<Product> getBag() {
        return bag;
    }

    /**
     * @param id setter
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @param sick setter
     */
    public void setIsSick(Boolean sick) {
        isSick = sick;
    }

    public void setWearsMask(Boolean wearsMask) {
        this.wearsMask = wearsMask;
    }

    /**
     * @param vaccinated setter
     */
    public void setVaccinated(Boolean vaccinated) {
        this.vaccinated = vaccinated;
    }

    public void setChanceToGetSick(Float chanceToGetSick) {
        this.chanceToGetSick = chanceToGetSick;
    }

    /**
     * @param shopsToGetWell setter
     */
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

package com.bartoszmaslanka144091;

import javafx.fxml.FXML;

import javafx.scene.control.Button;
import java.util.ArrayList;

public class Shop {
    String name;
    String address;
    int maxClientCapacity;
    int storageCapacity;
    ArrayList<Product> availableProducts;
    int peopleCapacity;
    boolean lockdown;
    boolean isSale;

    public void checkProductsDate(){};
    public void delOldProducts(){};

    public void setLockdown(Boolean value){
        this.lockdown = value;
    };

    public void setIs_sale(Boolean value){
        this.isSale = value;
    };

    public Shop(String name, String address, int maxClientCapacity, int storageCapacity, ArrayList<Product> availableProducts,
                int peopleCapacity, boolean lockdown, boolean isSale) {
        this.name = name;
        this.address = address;
        this.maxClientCapacity = maxClientCapacity;
        this.storageCapacity = storageCapacity;
        this.availableProducts = availableProducts;
        this.peopleCapacity = peopleCapacity;
        this.lockdown = lockdown;
        this.isSale = isSale;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
    @FXML private Button button;
    public void show(){
        System.out.println("Działa!!!");
    }
}

package com.bartoszmaslanka144091;

import javafx.collections.ObservableList;

public class Shop {
    String name;
    String address;
    int maxClientCapacity;
    int storageCapacity;
    ObservableList<Product> availableProducts;
    int peopleCapacity;
    boolean lockdown;
    boolean isSale;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void checkProductsDate(){};
    public void delOldProducts(){};

    public void setLockdown(Boolean value){
        this.lockdown = value;
    };

    public void setIs_sale(Boolean value){
        this.isSale = value;
    };

    public Shop(String name, String address, int maxClientCapacity, int storageCapacity, ObservableList<Product> availableProducts,
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
}

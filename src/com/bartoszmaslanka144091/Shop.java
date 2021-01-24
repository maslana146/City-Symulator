package com.bartoszmaslanka144091;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Shop {
    ObservableList<Product> availableProducts = FXCollections.observableArrayList();
    String name;
    String address;
    int peopleCapacity = 0;
    int maxClientCapacity;
    int storageCapacity = 0;
    int maxStorageCapacity;

    boolean lockdown;
    boolean isSale;

    public Shop(String name, String address, int maxClientCapacity, int maxStorageCapacity, boolean lockdown, boolean isSale) {
        this.name = name;
        this.address = address;
        this.maxClientCapacity = maxClientCapacity;
        this.maxStorageCapacity = maxStorageCapacity;
        this.lockdown = lockdown;
        this.isSale = isSale;
    }

    public int getPeopleCapacity() {
        return peopleCapacity;
    }

    public void setPeopleCapacity(int peopleCapacity) {
        this.peopleCapacity = peopleCapacity;
    }

    public int getStorageCapacity() {
        storageCapacity = getAvailableProducts().size();
        return storageCapacity;
    }
    public void enterPerson(){
        this.peopleCapacity +=1;
    };
    public void outPerson(){
        this.peopleCapacity -= 1;
    }
    public void setStorageCapacity(int storageCapacity) {
        this.storageCapacity = storageCapacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ObservableList<Product> getAvailableProducts() {
        return availableProducts;
    }

    public void setAvailableProducts(ObservableList<Product> availableProducts) {
        this.availableProducts = availableProducts;
    }

    public void checkProductsDate() {
    }

    ;

    public void delOldProducts() {
    }

    ;

    public void setLockdown(Boolean value) {
        this.lockdown = value;
    }

    ;

    public void setIs_sale(Boolean value) {
        this.isSale = value;
        if (this.isSale) {
            for (Product product : availableProducts) {
                product.chance_to_take += (1 - product.chance_to_take) / 2;
            }

        } else if (this.isSale == false) {
            for (Product product : availableProducts) {
                product.chance_to_take = (float) (product.chance_to_take * 0.6);
            }
        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getMaxClientCapacity() {
        return maxClientCapacity;
    }

    public void setMaxClientCapacity(int maxClientCapacity) {
        this.maxClientCapacity = maxClientCapacity;
    }

    public int getMaxStorageCapacity() {
        return maxStorageCapacity;
    }

    public void setMaxStorageCapacity(int maxStorageCapacity) {
        this.maxStorageCapacity = maxStorageCapacity;
    }


    public boolean isLockdown() {
        return lockdown;
    }

    public void setLockdown(boolean lockdown) {
        this.lockdown = lockdown;
    }

    public boolean isSale() {
        return isSale;
    }

    public void setSale(boolean sale) {
        isSale = sale;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

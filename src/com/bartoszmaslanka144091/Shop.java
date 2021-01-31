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
    int lockdownCapacity;
    int saveMaxCapacity;
    boolean lockdown;
    boolean isSale;


    /**
     * constuctor
     * @param name
     * @param address
     * @param maxClientCapacity
     * @param maxStorageCapacity
     * @param lockdown
     * @param isSale
     */
    public Shop(String name, String address, int maxClientCapacity, int maxStorageCapacity, boolean lockdown, boolean isSale) {
        this.name = name;
        this.address = address;
        this.maxClientCapacity = maxClientCapacity;
        this.maxStorageCapacity = maxStorageCapacity;
        this.lockdown = lockdown;
        this.isSale = isSale;
        this.lockdownCapacity = maxClientCapacity/4;
        this.saveMaxCapacity = maxClientCapacity;
    }

    /**
     * @return 25% of max capacity
     */
    public int getLockdownCapacity() {
        return lockdownCapacity;
    }

    public void setLockdownCapacity(int lockdownCapacity) {
        this.lockdownCapacity = lockdownCapacity;
    }

    /**
     * @return getter
     */
    public int getSaveMaxCapacity() {
        return saveMaxCapacity;
    }

    public void setSaveMaxCapacity(int saveMaxCapacity) {
        this.saveMaxCapacity = saveMaxCapacity;
    }

    /**
     * @return getter
     */
    public int getPeopleCapacity() {
        return peopleCapacity;
    }

    /**
     * @param peopleCapacity setter
     */
    public void setPeopleCapacity(int peopleCapacity) {
        this.peopleCapacity = peopleCapacity;
    }

    /**
     * @return getter
     */
    public int getStorageCapacity() {
        storageCapacity = getAvailableProducts().size();
        return storageCapacity;
    }

    /**
     * increase people capacity by 1
     */
    public void enterPerson(){
        this.peopleCapacity +=1;
    };

    /**
     * decrease people capacity by 1
     */
    public void outPerson(){
        this.peopleCapacity -= 1;
    }

    /**
     * @param storageCapacity setter
     */
    public void setStorageCapacity(int storageCapacity) {
        this.storageCapacity = storageCapacity;
    }

    /**
     * @return getter
     */
    public String getName() {
        return name;
    }

    /**
     * @param name setter
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return getter
     */
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

    /**
     * @param value increase cahnce to take of each product
     */
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

    /**
     * @return getter
     */
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return getter
     */
    public int getMaxClientCapacity() {
        return maxClientCapacity;
    }

    /**
     * @param maxClientCapacity setter
     */
    public void setMaxClientCapacity(int maxClientCapacity) {
        this.maxClientCapacity = maxClientCapacity;
    }

    /**
     * @return getter
     */
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

    /**
     * @return getter
     */
    public boolean isSale() {
        return isSale;
    }

    public void setSale(boolean sale) {
        isSale = sale;
    }

    /**
     * @return to string method
     */
    @Override
    public String toString() {
        return "Shop{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

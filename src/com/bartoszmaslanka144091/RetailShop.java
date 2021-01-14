package com.bartoszmaslanka144091;

import javafx.collections.ObservableList;

public class RetailShop extends Shop{

    public void isFullyProd(){};
    public void isFullyPer(){};
    //TODO dodaj cell do ktorego będą dążyć supplierzy/clienci
    public RetailShop(String name, String address, int max_client_capacity, int storage_capacity,
                      ObservableList<Product> available_products, int people_capacity, Boolean lockdown, Boolean is_sale) {
        super(name, address, max_client_capacity, storage_capacity, available_products, people_capacity, lockdown, is_sale);
    }
    public void createStartProducts(){
        int numOfProd = Generators.genInteger(0,storageCapacity/3);
        for (int i=0;i<numOfProd;i++){
            Product product = new Product(Generators.newId(),Generators.genString(5),Generators.brandName(),Generators.genInteger(0,5),
                    Generators.genFloat(0,1),Generators.genBool());
            availableProducts.add(product);
        }
    }
}

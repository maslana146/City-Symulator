package com.bartoszmaslanka144091;

public class RetailShop extends Shop{

    public void isFullyProd(){};
    public void isFullyPer(){};


    public RetailShop(String name, String address, int maxClientCapacity, int maxStorageCapacity, boolean lockdown, boolean isSale) {
        super(name, address, maxClientCapacity, maxStorageCapacity, lockdown, isSale);
    }

    public void createStartProducts(){
        int numOfProd = Generators.genInteger(1, maxStorageCapacity);
        for (int i=0;i<numOfProd;i++){
            Product product = new Product(Generators.newId(),Generators.genString(5),Generators.brandName(),Generators.genInteger(0,5),
                    Generators.genFloat(0,1),Generators.genBool());
            availableProducts.add(product);
        }
    }
}

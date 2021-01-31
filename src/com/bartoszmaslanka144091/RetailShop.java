package com.bartoszmaslanka144091;

public class RetailShop extends Shop{

    /**
     * constuctor
     * @param name
     * @param address
     * @param maxClientCapacity
     * @param maxStorageCapacity
     * @param lockdown
     * @param isSale
     */
    public RetailShop(String name, String address, int maxClientCapacity, int maxStorageCapacity, boolean lockdown, boolean isSale) {
        super(name, address, maxClientCapacity, maxStorageCapacity, lockdown, isSale);
    }

    /**
     * create start products in retail shop
     */
    public void createStartProducts(){
        int numOfProd = Generators.genInteger(1, maxStorageCapacity);
        for (int i=0;i<numOfProd;i++){
            Product product = new Product(Generators.newId(),Generators.prodName(),Generators.brandName(),Generators.genInteger(0,5),
                    Generators.genFloat(0,1),Generators.genBool());
            availableProducts.add(product);
        }
    }
}

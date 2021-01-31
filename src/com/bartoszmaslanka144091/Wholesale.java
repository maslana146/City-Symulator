package com.bartoszmaslanka144091;

public class Wholesale extends Shop{

    /**
     * create new product function
     */
    public void createProduct(){
        if (storageCapacity < maxStorageCapacity) {
            int id = Generators.newId();
            String name = Generators.prodName();
            String brand = Generators.brandName();
            int time = Generators.genInteger(120, 600);
            float chance = Generators.genFloat(0, 1);
            boolean sale = false;
            Product product = new Product(id, name, brand, time, chance, sale);
            this.availableProducts.add(product);
//            System.out.println(availableProducts);

        }
    };

    /**
     * constuctor
     * @param name
     * @param address
     * @param maxClientCapacity
     * @param maxStorageCapacity
     * @param lockdown
     * @param isSale
     */
    public Wholesale(String name, String address, int maxClientCapacity, int maxStorageCapacity, boolean lockdown, boolean isSale) {
        super(name, address, maxClientCapacity, maxStorageCapacity, lockdown, isSale);
    }
}

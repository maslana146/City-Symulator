package com.bartoszmaslanka144091;

public class Wholesale extends Shop{

    public void createProduct(){
        int id = Generators.genInteger(0,100);
        String name = Generators.genString(5);
        String brand = Generators.brandName();
        int time = Generators.genInteger(120, 600);
        float chance = Generators.genFloat(0,1);
        boolean sale = false;
        Product product = new Product(id,name,brand,time,chance,sale);
        this.availableProducts.add(product);
        System.out.println(availableProducts);

    };

    public Wholesale(String name, String address, int maxClientCapacity, int maxStorageCapacity, boolean lockdown, boolean isSale) {
        super(name, address, maxClientCapacity, maxStorageCapacity, lockdown, isSale);
    }
}

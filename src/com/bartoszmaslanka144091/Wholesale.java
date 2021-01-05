package com.bartoszmaslanka144091;

import java.util.ArrayList;

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

    };

    public Wholesale(String name, String address, int max_client_capacity, int storage_capacity,
                     ArrayList<Product> available_products, int people_capacity, Boolean lockdown, Boolean is_sale) {
        super(name, address, max_client_capacity, storage_capacity, available_products, people_capacity, lockdown, is_sale);
    }
}

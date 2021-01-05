package com.bartoszmaslanka144091;

import java.util.ArrayList;

public class RetailShop extends Shop{

    public void isFullyProd(){};
    public void isFullyPer(){};

    public RetailShop(String name, String address, int max_client_capacity, int storage_capacity,
                      ArrayList<Product> available_products, int people_capacity, Boolean lockdown, Boolean is_sale) {
        super(name, address, max_client_capacity, storage_capacity, available_products, people_capacity, lockdown, is_sale);
    }
}

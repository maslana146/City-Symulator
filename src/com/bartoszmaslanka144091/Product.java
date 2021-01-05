package com.bartoszmaslanka144091;

public class Product {
    int id;
    String name;
    String brand;
    int best_before_date;
    Float chance_to_take;
    Boolean on_sale;

    void setOn_sale(Boolean value){
        this.on_sale = value;
    }
    public Product(int id, String name, String brand, int best_before_date, Float chance_to_take, Boolean on_sale) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.best_before_date = best_before_date;
        this.chance_to_take = chance_to_take;
        this.on_sale = on_sale;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", best_before_date=" + best_before_date +
                ", on_sale=" + on_sale +
                '}';
    }
}

package com.bartoszmaslanka144091;

public class Product {
    int id;
    String name;
    String brand;
    int best_before_date;
    float chance_to_take;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getBest_before_date() {
        return best_before_date;
    }

    public void setBest_before_date(int best_before_date) {
        this.best_before_date = best_before_date;
    }

    public Float getChance_to_take() {
        return chance_to_take;
    }

    public void setChance_to_take(Float chance_to_take) {
        this.chance_to_take = chance_to_take;
    }

    public Boolean getOn_sale() {
        return on_sale;
    }
}

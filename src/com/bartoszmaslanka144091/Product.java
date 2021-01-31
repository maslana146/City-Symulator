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

    /**
     * constructor
     * @param id
     * @param name
     * @param brand
     * @param best_before_date
     * @param chance_to_take
     * @param on_sale
     */
    public Product(int id, String name, String brand, int best_before_date, Float chance_to_take, Boolean on_sale) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.best_before_date = best_before_date;
        this.chance_to_take = chance_to_take;
        this.on_sale = on_sale;
    }

    /**
     * @return to string method
     */
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

    /**
     * @return getter
     */
    public int getId() {
        return id;
    }

    /**
     * @param id setter
     */
    public void setId(int id) {
        this.id = id;
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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * @return getter
     */
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

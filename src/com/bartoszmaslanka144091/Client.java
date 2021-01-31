package com.bartoszmaslanka144091;

import com.bartoszmaslanka144091.Controllers.WorldScreen;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.shape.Circle;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Client extends Person {
    String firstName;
    String lastName;
    int positionX;
    int positionY;
    Circle circle;
    StaticObject nextshop;


    /**
     * client after visiting n shops consume some products
     */
    public void consume() {
//        System.out.println(this.getBag());
        Comparator<Product> comparator = Comparator.comparingInt(Product::getBest_before_date);
        FXCollections.sort(bag,comparator);
        int x = 0;
        List<Product> ls =bag.stream().filter(c -> c.getBest_before_date() == 0).collect(Collectors.toList());
        for (Product product: ls){
            bag.remove(product);
            x += 1;
        }
//        System.out.println(getFirstName()+" consume "+ x + "products");
        for (Product product:bag){
            product.best_before_date -= 1;

        }


//        List bagLs = Collections.sort(bag,p);
//        for (int i = 0; i<Generators.genInteger(0,currentCapacity);i++){
//            bag.remove(bag.get(i));
//        }
    }

    ;

    /**
     * @return getter
     */
    public StaticObject getNextshop() {
        return nextshop;
    }

    /**
     * sets new next shop
     */
    public void setNextshop() {
        List<StaticObject> staticObjects = WorldScreen.staticObjects.stream().filter(p ->
                p.getRetailShop() != null).collect(Collectors.toList());
        int nextShop = Generators.genInteger(3, staticObjects.size());
        this.nextshop = staticObjects.get(nextShop);
    }

    public RetailShop nextShop() {
        List<RetailShop> retailShopList = Program.getInstance().listOfRetailShops;
        int shop = Generators.genInteger(0, Program.getInstance().listOfRetailShops.size());

        return retailShopList.get(shop);
    }

    /**consturctor
     * @param id
     * @param isSick
     * @param wearsMask
     * @param vaccinated
     * @param chanceToGetSick
     * @param shopsToGetWell
     * @param currentCapacity
     * @param maxCapacity
     * @param bag
     * @param firstName
     * @param lastName
     */
    public Client(int id, Boolean isSick, Boolean wearsMask, Boolean vaccinated, Float chanceToGetSick, int shopsToGetWell,
                  int currentCapacity, int maxCapacity, ObservableList<Product> bag, String firstName, String lastName) {
        super(id, isSick, wearsMask, vaccinated, chanceToGetSick, shopsToGetWell, currentCapacity, maxCapacity, bag);
        this.firstName = firstName;
        this.lastName = lastName;

    }

    /**
     * @return to string method
     */
    @Override
    public String toString() {
        return "Client{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", cartCapacity=" + this.maxCapacity +
                ", cart=" + bag +
                '}';
    }

    public Circle getCircle() {
        return circle;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }
//    public Circle getObj() {
//        return obj;
//    }
//
//    public void setObj(Circle obj) {
//        this.obj = obj;
//    }

    /**
     * @return getter
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @return getter
     */
    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}



package com.bartoszmaslanka144091;

import com.bartoszmaslanka144091.Controllers.WorldScreen;
import javafx.scene.shape.Circle;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Client extends Person {
    String firstName;
    String lastName;
    int positionX;
    int positionY;
    Circle circle;
    StaticObject nextshop;


    public void consume() {

    }

    ;

    public StaticObject getNextshop() {
        return nextshop;
    }

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

    public Client(int id, Boolean isSick, Boolean wearsMask, Boolean vaccinated, Float chanceToGetSick, int shopsToGetWell,
                  int currentCapacity, int maxCapacity, ArrayList<Product> bag, String firstName, String lastName) {
        super(id, isSick, wearsMask, vaccinated, chanceToGetSick, shopsToGetWell, currentCapacity, maxCapacity, bag);
        this.firstName = firstName;
        this.lastName = lastName;

    }

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

    public String getFirstName() {
        return firstName;
    }

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



package com.bartoszmaslanka144091;

import javafx.scene.shape.Rectangle;

public class StaticObject extends Rectangle {
    RetailShop retailShop;
    Wholesale wholesale;
    Cell cell;
    Cell goToCell;

    public Cell getGoToCell() {
        return goToCell;
    }

    public void setGoToCell(Cell goToCell) {
        this.goToCell = goToCell;
    }

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public StaticObject(double x, double y, double width, double height) {
        super(x, y, width, height);
    }

    public RetailShop getRetailShop() {
        return retailShop;
    }

    public void setRetailShop(RetailShop retailShop) {
        this.retailShop = retailShop;
    }

    public Wholesale getWholesale() {
        return wholesale;
    }

    public void setWholesale(Wholesale wholesale) {
        this.wholesale = wholesale;
    }

}


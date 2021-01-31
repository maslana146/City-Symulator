package com.bartoszmaslanka144091;

import javafx.scene.shape.Rectangle;

public class StaticObject extends Rectangle {
    RetailShop retailShop;
    Wholesale wholesale;
    Cell cell;
    Cell goToCell;

    /**
     * @return getter
     */
    public Cell getGoToCell() {
        return goToCell;
    }

    /**
     * @param goToCell setter
     */
    public void setGoToCell(Cell goToCell) {
        this.goToCell = goToCell;
    }

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    /**
     * @param x
     * constuctor
     * @param y
     * @param width
     * @param height
     */
    public StaticObject(double x, double y, double width, double height) {
        super(x, y, width, height);
    }

    /**
     * @return getter
     */
    public RetailShop getRetailShop() {
        return retailShop;
    }

    /**
     * @param retailShop setter
     */
    public void setRetailShop(RetailShop retailShop) {
        this.retailShop = retailShop;
    }

    /**
     * @return getter
     */
    public Wholesale getWholesale() {
        return wholesale;
    }

    /**
     * @param wholesale setter
     */
    public void setWholesale(Wholesale wholesale) {
        this.wholesale = wholesale;
    }

}


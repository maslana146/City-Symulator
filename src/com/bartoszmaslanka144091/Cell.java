package com.bartoszmaslanka144091;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Cell extends StackPane {
    int x, y;
    String type;
    boolean availableForClients;
    boolean availableForSuppliers;
    int centerX;
    int centerY;
    boolean isThereShop;


    /**
     * @param thereShop sets shops in cell
     */
    public void setThereShop(boolean thereShop) {
        isThereShop = thereShop;
    }

    Rectangle border = new Rectangle(Map.cellSize,Map.cellSize);


    /**
     * @param x constructor
     * @param y
     * @param type
     * @param availableForClients
     * @param availableForSuppliers
     */
    public Cell(int x, int y, String type, boolean availableForClients, boolean availableForSuppliers) {
        this.x = x * Map.cellSize;
        this.y = y * Map.cellSize;
        this.type = type;
        this.availableForClients = availableForClients;
        this.availableForSuppliers = availableForSuppliers;
        this.centerX = this.x + (Map.cellSize/2);
        this.centerY = this.y + (Map.cellSize/2);
        border.setStroke(Color.LIGHTGRAY);


    }

    public boolean getIsThereShop() {
        return isThereShop;
    }

    /**
     * @return to string method
     */
    @Override
    public String toString() {
        return "Cell{" +
                "x=" + x/25 +
                ", y=" + y/25 +
                ", for clients=" + availableForClients +
                '}';
    }

    /**
     * @return get center x coordinate
     */
    public int getCenterX() {
        return centerX;
    }

    /**
     * @return get center y coordinate
     */
    public int getCenterY() {
        return centerY;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setType(String type) {
        this.type = type;
    }

    /**
     * @param availableForClients setter
     */
    public void setAvailableForClients(boolean availableForClients) {
        this.availableForClients = availableForClients;
    }

    /**
     * @param availableForSuppliers setter
     */
    public void setAvailableForSuppliers(boolean availableForSuppliers) {
        this.availableForSuppliers = availableForSuppliers;
    }

    public void setBorder(Rectangle border) {
        this.border = border;
    }

    /**
     * @return get x coordinate
     */
    public int getX() {
        return x;
    }

    /**
     * @return get y coordinate
     */
    public int getY() {
        return y;
    }

    public String getType() {
        return type;
    }

    public boolean isAvailableForClients() {
        return availableForClients;
    }

    public boolean isAvailableForSuppliers() {
        return availableForSuppliers;
    }

}
